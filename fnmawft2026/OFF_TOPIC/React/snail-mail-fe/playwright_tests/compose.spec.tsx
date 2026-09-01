import {test, expect, request} from '@playwright/test'

//Before each test, go to our main page (render the App.tsx)
//Then, click open the Compose Component
test.beforeEach(async ({ page }) => {
    await page.goto('/') //Playwright goes to the baseURL defined in our config file 
    await page.getByRole('button', {name: "Compose Email"}).click() //Open Compose.tsx
    
    //an assertion in the beforeEach - make sure compose exists
    await expect(page.getByTestId("compose-component")).toBeVisible()
})

//Test 1: Make sure user can compose and send a valid email ----------
test("user can send email via compose component", async ({page}) => {

    //I like to select elements by the easiest field to access that's still unique
    await page.getByRole("textbox", {name: "recipient"}).fill("test@snailmail.com")
    await page.getByRole("textbox", {name: "subject"}).fill("anything")
    await page.getByRole("textbox", {name: "body"}).fill("anything at all")

    //dialog - an event that gets emitted when a dialog element appears (like our alert()!)
    page.once('dialog', async (dialog) => {
        expect(dialog.message()).toEqual("Sent Mail to: test@snailmail.com")
        await dialog.accept() //.accept() is like hitting "ok" to dismiss the alert
        //NOTE: we won't see this alert in the GUI, Playwright automatically dismisses them
    })

    //click the send button (which should trigger our eventListener)
    await page.getByRole('button', {name: "Send"}).click()

    //Wait for an HTTP response to come back from the /mail URL
    const response = await page.waitForResponse("http://localhost:8080/mail")

    //Run some assertions on the values of the HTTP Response
    expect(response.status()).toBe(200) //check that the status code === 200

    //extract the response data to test the fields
    const jsonResponse = await response.json();
    expect(jsonResponse.recipient).toBe("test@snailmail.com")
    
    //TODO: This doesn't work in Firefox, json parsing issues. 
})

//Test 2: Check that the appropriate alert is sent when an email is sent with no Subject
test("shows alert when trying to send mail with no subject", async ({page}) => {

    //Fill only the Recipient and Body, leaving Subject empty
    //(Note we're using getByPlaceholder this time just to show it)
    await page.getByPlaceholder("recipient").fill("test@snailmail.com")
    await page.getByPlaceholder("Write your message here...").fill("This won't send!")

    //Listen for another dialog event - this should be our "no subject" alert()
    page.once('dialog', async (dialog) => {
        expect(dialog.message()).toEqual("Subject cannot be empty")
        //leaving out the accept() since it happens automatically in Playwright
    })

    //Maybe not necessary but just wanna show some more assertions - make sure subject is empty
    await expect(page.getByPlaceholder("subject")).toBeEmpty()

    //Click send to trigger the alert
    await page.getByText("Send").click

}) 

//Test 3: The backend sends an erroneous response when mail is sent with no recipient
test("backend rejects emails with missing recipient", async () => {

    //Recall that the backend should send a null body and a 400 status code 
    //IF the recipient field is empty.
    //Yes, the front end checks for this, but we'll send a manual HTTP request to bypass that check

    //Make a new ApiRequestContext so we can directly send an HTTP request 
    const requestContext = await request.newContext()

    //Directly send a POST with an email object - this returns an ApiResponse object
    const response = await requestContext.post("http://localhost:8080/mail", {
        data:{
            sender: "me@snailmail.com",
            recipient: "",
            subject: "The backend wont allow this",
            body: "Test test test"
        }
    })

    //make sure we get a 400 status code (bad request)
    expect(response.status()).toBeGreaterThanOrEqual(400)

    //make sure the response body is null
    const body = await response.text() //turn it into text (can't parse JSON from null)
    expect(body).toContain("Recipient cannot be empty!")

})

//Test 4: test for the appropriate alert if the backend is down (mocking this request!!)
test("shows Network Error alert if backend is down on mail send", async ({page}) => {

    //Intercept the HTTP request (route()), and force it to fail (abort())
    await page.route("**/mail", route => {
        route.abort() //Simulating the server being down, or something causing the request to fail
    })

    //Fill out a valid form (we don't want any front end checks to run first)
    await page.getByRole("textbox", {name: "recipient"}).fill("test@snailmail.com")
    await page.getByRole("textbox", {name: "subject"}).fill("anything")
    await page.getByRole("textbox", {name: "body"}).fill("anything at all")

    //Listen for the alert and assert the appropriate message
    page.once('dialog', async (dialog) => {
        expect(dialog.message()).toContain("Network Error")
    })

    //Attempt to send the mail (which should get aborted due to our mocking in the request
    await page.getByRole('button', {name: "Send"}).click()

})

//Test 5: compose component goes away and "compose email" reappears when "x" is clicked
test("close compose component, render Compose Email button when X is clicked", async ({page}) => {

    //Click the X button - using locator() directly just to show it
    await page.locator('.btn-close').click() //selecting by the element with className = "btn-close"

    //Assert that Compose.tsx is no longer in the DOM - note the use of the .not property
    await expect(page.getByTestId("compose-component")).not.toBeVisible()

    //Assert that the "Compose Email" button reappears
    await expect(page.getByRole("button", {name:"Compose Email"})).toBeVisible()

})

//Test 6: make sure the error page renders when visiting an invalid URL
//NOTE: not really a compose component thing... but I'm putting it here anyway
test("error page component renders when invalid URL is visited", async ({browser}) => {

    //Create a new Browser context - isolated from the actual browser the app is running on
    const browserContext = await browser.newContext()

    //Create a new page based on this isolated Browser Context
    const page = await browserContext.newPage()

    //use the page to navigate to an invalid URL!
    await page.goto("http://localhost:5177/invalidURL")

    //Assert that our error page shows up
    await expect(page.getByText("Welcome to the Error Page")).toBeVisible()

    //good practice - close your context once you're done with it
    await browserContext.close()
})

//Test 7: Tests logs the correct response data - example of using ConsoleMessage
test("logs correct data from the backend after sending an email", async ({page}) => {

    //Fill out a valid form
    await page.getByRole("textbox", {name: "recipient"}).fill("test@snailmail.com")
    await page.getByRole("textbox", {name: "subject"}).fill("anything")
    await page.getByRole("textbox", {name: "body"}).fill("anything at all")

    //Listen for console messages, and assert the printed data
    page.on('console', async (message) => {

        //Firefox is strict - gotta convert this value before asserting what it equals
        const parsedMessage = await message.args()[0].jsonValue()

        expect(parsedMessage).toEqual(
        expect.objectContaining({
            sender: "me@snailmail.com",
            recipient: "test@snailmail.com",
            subject: "anything",
            body: "anything at all"
        }))

        
    })

    //Click send so that the console event actually trigger
    await page.getByRole('button', {name: "Send"}).click()

})

//Test 1.5: Make sure user can compose and send a valid email (NOW WITH A .HAR FILE!)
test("user can send email via compose component... NOW WITH .HAR FILE", async ({browser}) => {

    //Create a new context so we can record a .HAR file
    const browserContext = await browser.newContext({
        recordHar: {
            path: "har-files/sendmail.har", //the folder/file the .HAR file will reside in,
            content: "embed" //embed the response bodies into the .HAR file
        }
    })

    //since the BrowserContext ignores the beforeEach, we have a little setup to do
    const page = await browserContext.newPage()
    await page.goto('/') //Playwright goes to the baseURL defined in our config file 
    await page.getByRole('button', {name: "Compose Email"}).click() //Open Compose.tsx

    //I like to select elements by the easiest field to access that's still unique
    await page.getByRole("textbox", {name: "recipient"}).fill("test@snailmail.com")
    await page.getByRole("textbox", {name: "subject"}).fill("anything")
    await page.getByRole("textbox", {name: "body"}).fill("anything at all")

    //dialog - an event that gets emitted when a dialog element appears (like our alert()!)
    page.once('dialog', async (dialog) => {
        expect(dialog.message()).toEqual("Sent Mail to: test@snailmail.com")
        await dialog.accept() //.accept() is like hitting "ok" to dismiss the alert
        //NOTE: we won't see this alert in the GUI, Playwright automatically dismisses them
    })

    //click the send button (which should trigger our eventListener)
    await page.getByRole('button', {name: "Send"}).click()

    //Wait for an HTTP response to come back from the /mail URL
    const response = await page.waitForResponse("http://localhost:8080/mail")

    //Run some assertions on the values of the HTTP Response
    expect(response.status()).toBe(200) //check that the status code === 200

    //extract the response data to test the fields
    const jsonResponse = await response.json();
    expect(jsonResponse.recipient).toBe("test@snailmail.com")
    
    //This command closes the context, which records the HAR file
    await browserContext.close()

    //TODO: This doesn't work in Firefox, json parsing issues. 
})