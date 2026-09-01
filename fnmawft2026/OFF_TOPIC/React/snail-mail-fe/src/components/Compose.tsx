
//Takes 2 Values:
    //1) The function that closes this component

import axios, { AxiosError } from "axios"
import { useState } from "react"

//our Props interface outlines 1 entity
// 1) The function that closes the component
interface Props {
    onClose: () => void
}

//Redefining the Mail Interface - We can reduce rewrites of this if we made a global Interface file instead
interface Mail {
    sender: string
    recipient: string
    subject: string
    body: string
}

//Props stands for "properties" - the object of properties passed into the component
//Note the "...testId" - this is the data attribute that we'll use to select this component for tests
export const Compose:React.FC<Props> = ({onClose, ...testId}) => {

    //useState for the mail object - as the inputs in Compose change, this object will be filled with values
    const [mailToSend, setMailToSend] = useState<Mail>({
        sender: "me@snailmail.com",
        recipient: "",
        subject: "",
        body: ""
    })

    const handleInputChange = (event:React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
        
        //Storing the name and value attributes from the changed element for ease of use
        //[name] can be either of the 3 inputs in the Compose component. This ugly code lends flexibility
        //This syntax becomes way more necessary when we have a ton of input fields
        const name = event.target.name //name is an attribute we set in the inputs
        const value = event.target.value //value is whatever value is in the input box

        //"Take whatever input was changed, and set the matching state field to the value of the input"
        setMailToSend((mailToSend) => ({...mailToSend, [name]:value}))

        console.log(mailToSend)
    }

    const sendEmail = async () => {

        try{

            //Error handling
                //Check that subject is not empty
                //Check that recipient is a valid email address (follows x@y format)
            //TODO: probably cut all this as we turn our inputs into a form and validate it that way
            if(mailToSend.subject.trim() === ""){
                throw Error("Subject cannot be empty")
            }

            if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(mailToSend.recipient)) {
                throw new Error("Recipient doesn't appear to be a valid email address");
            }

            //send email (POST request)
            const response = await axios.post("http://localhost:8080/mail", mailToSend)

            console.log(response.data) //just so we can see this in console

            alert("Sent Mail to: " + response.data.recipient)

            onClose() //close the component after sending mail
        } catch (e) {
            //e is "unknown" type here - so we need to check its type before we can do Error-related stuff
            if(e instanceof AxiosError){
                console.log(e)
                alert(e.message)
            } else {
                alert("Some unknown error occurred!")
            }
        }

    }

    return(
        <div className="card shadow position-absolute bottom-0 end-0 m-5 " {...testId}>

            <h6 className="border-bottom position-absolute top-0 start-0 m-2">Compose Email</h6>
            <button onClick={onClose} className="btn-close position-absolute top-0 end-0 m-1"></button>

            {/* TODO: make this a form so we can have required fields and clean up the sendMail function */}
            <div>
                <input className="form-control border-bottom border-0 shadow-none" placeholder="recipient" name="recipient" type="email" onChange={handleInputChange}/>
            </div>

            <div>
                <input className="form-control border-bottom border-0 shadow-none" placeholder="subject" name="subject" onChange={handleInputChange}/>
            </div>

            <div className="card-body">
                <textarea aria-label="body" name="body" placeholder="Write your message here..." className="form-control border-0 shadow-none" rows={6} onChange={handleInputChange}></textarea>
            </div>

            <button className="btn btn-sm btn-outline-primary d-block mx-auto" onClick={sendEmail}>Send</button>

        </div>
    )

}