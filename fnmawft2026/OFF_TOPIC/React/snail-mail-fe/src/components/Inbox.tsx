//This is our first custom Component
//Components contain logic AND view in the same file
//It's like we merged an HTML file with the JS file that gives it functionality

import axios from "axios"
import { useEffect, useState } from "react"
import { Table } from "react-bootstrap"

//Interfaces in React/TS help us model data. It's like making a custom datatype
interface Mail {
    sender: string
    recipient: string
    subject: string
    body: string
}

export const Inbox:React.FC = () => {

    //Logic goes up here (written in TypeScript)

    /*Store a Mail[] in a useState hook
    useState is good for storing data, like a variable
    in a component it's preferred over a variable because it will RE RENDER the component when its value changes */
    const [inbox, setInbox] = useState<Mail[]>([])
    /* useState anatomy:
        -the variable that stores our data (inbox)
        -the mutator function that lets us change the data (setInbox) 
        -the actual useState hook which initializes all of this
        -<the datatype of the variable>
        -(the initial value of the variable)
    */

    
    //useEffect is a hook we can use to invoke functionality at certain events
    //It's commonly used to make things happen as soon as the component renders
    useEffect(() => {
        //Let's populate the inbox as soon as the component renders
        getInbox()
    }, []) //[] to make the useEffect run once the component renders


    //Function that gathers our inbox (Will be a real HTTP request in a bit)
    const getInbox = async () => {

        try{
            //Send an axios GET request to the API to get inbox mail (yes, we can use fetch too!)
            const response = await axios.get("http://localhost:8080/mail")

            //Use the mutator (setInbox) to set this data to our "inbox" state variable
            setInbox(response.data)
        } catch {
            alert("There was a problem when fetching your inbox! Please try again later")
        }

    }

    //View goes down here - rememeber return() needs a wrapper element (we used a div) 
    return(
        <div>

            <h3 className="font-monospace">Inbox</h3>

            {/* CONDITIONAL RENDERING
            If there's no mail, render a message that says there's no mail 
            If there IS mail, render the table with the inbox rows*/}

            {inbox.length === 0 ? (
                <div className="alert alert-primary">No Mail! You're all caught up!</div>)
            : (
                <Table hover>
                <thead>
                    <tr>
                        <th>Subject</th>
                        <th>Sender</th>
                        <th>Message</th>
                    </tr>
                </thead>
                <tbody>
                    {/*For every email in the inbox, render a new table row with its data */}
                    {inbox.map((mail)=>(
                        <tr>
                            <td>{mail.subject}</td>
                            <td>{mail.sender}</td>
                            <td>{mail.body}</td>
                        </tr>
                    ))}
                    {/* Why () intead of {} for the arrow function? this lets us implicitly return the view, otherwise we'd have to define it with a return() */}
                </tbody>
            </Table>
            )}

        </div>
    )

}