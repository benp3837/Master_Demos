//We'll see: How to switch HTML pages, send data between pages, and send a POST request

document.getElementById("loginButton").onclick = login

async function login(){

    //prevent the default behavior, 
    //lets us do button.onclick instead of jumping thru form hoops
    event.preventDefault();

    const username = document.getElementById("username").value
    const password = document.getElementById("password").value

    //Let's save these two values into an object (easier for the POST request)
    //This looks a lot like out LoginDTO doesn't it? 
    const loginCreds = {
        username:username,
        password:password
    }

    // if(username === "jonah" && password === "haramkim"){
    //     localStorage.setItem("username", username) //setting data in local storage (accessible across HTML files)
    //     window.location.href = "HelloFetch.html"
    // } else {
    //     alert("username or password are incorrect!")
    // }

    //Here's our POST in a fetch() request
    try{

        //Any non-GET request is a bit more involved. 
        //Gotta set the HTTP verb, headers, request body in a config object
        const response = await fetch("http://localhost:8080/auth/login",
            {
                method:"POST",
                headers:{
                    "Content-Type":"application/json"
                },
                body:JSON.stringify(loginCreds) //Turn the body with JSON.stringify()
            }
        )

        //Check out this easy way to check for 200 OK
        if(response.ok){

            //turn the response into JS
            const data = await response.json()

            //set data in localStorage
            localStorage.setItem("userId", data.userId)
            localStorage.setItem("username", data.username)
            localStorage.setItem("role", data.role)

            //switch HTML page based on ROLE
            if(localStorage.getItem("role") === "zookeeper"){
                window.location.href = "Zookeeper.html"
            } else {
                window.location.href = "HelloFetch.html"
            }
            

            /*!PROJECT NOTE - 

            Since User data is getting sent back, you have a lot of fields to work with
            You have a lot of potential for CONDITIONALS and PERSONALIZATIONS!
                -Navigate to different HTML pages based on the role
                -Use the user's name to personalize
                -Store the User's ID to simplify your get___ById HTTP requests
                    -Great way to get all User loans right after login (populate a table?) */
        }
        else {
            alert("Invalid credentials!")
        }

    }
    catch(error){
        console.error(error) //print out the error as an error log
        alert("Login Failed!")
    }
    

}