import { useEffect, useState } from "react"
import { UserInterface } from "../../interfaces/UserInterface"
import { Button, Table } from "react-bootstrap"
import axios from "axios"

//NOTE: this is my most verbose and tricky syntax component - I tried to show some cool stuff
//If you need a more basic example of list rendering, check out CarContainer and Car

//We've defined that props are an Array of UserInterface[] called "users"
export const User: React.FC<{users:UserInterface[]}> = ({users}) => {

    //useEffect just to print our users for debugging purposes
    useEffect(() => {
        console.log(users)
    })

    //useState hooks for selectedUser<UserInterface> 
    const [selectedUser, setSelectedUser] = useState<UserInterface>({
        userId:0,
        username:"default_user",
        role:""
    })

    //useState hook for the userOptions boolean
    const [userOptions, setUserOptions] = useState<boolean>(false)

    //useState hook for newUsername
    const [newUsername, setNewUsername] = useState<string>("")

    //a function to toggle the boolean and store selected user data
    const selectUserData = (user:UserInterface) => {
        setSelectedUser(user)
        setUserOptions(!userOptions)
    }

    //a function to update a user with a new username
    const updateUsername = async () => {

        //newUsername will be truthy if it's not an empty string
        //Remeber axios parameters: axios.someMethod(url, request body, config object)
        if(newUsername){
            const response = await axios.patch("http://localhost:8080/users/" + selectedUser.userId, newUsername, {
                headers: {"Content-Type":"text/plain"} 
                //we had to set this to text in the headers object, since the backend expects a string here
            })
            console.log(response.data)
            setUserOptions(!userOptions)
        }

    }

    return(
        <div className="container">

            <h3>Welcome Admin! All Users: </h3>

            {/* user info/options that pop up when the "userOptions" boolean is true 
            This will get toggled true/false when a user row is clicked*/}
            {userOptions?
                <div className="m-5 w-25 d-flex flex-row">
                    <p className="m-2">{selectedUser.username}</p>
                    <input className="m-2" type="text" placeholder="new username" onChange={(input) => {
                        setNewUsername(input.target.value)
                    }}/>
                    <button className="m-2" onClick={updateUsername}>Submit</button>
                    <button className="m-2">Delete</button>
                </div>
                :
                <></>
            }

            <Table striped bordered hover variant="primary">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Username</th>
                        <th>Role</th>
                        <th>Options</th>
                    </tr>
                </thead>
                <tbody>
                    {users.map((user, index) => (
                        <tr key={user.userId} onClick={() => {selectUserData(user)}}>
                            <td >{user.userId}</td>
                            <td>{user.username}</td>
                            <td>{user.role}</td>
                            <td><Button variant="outline-danger">Fire User</Button></td>
                        </tr>
                    ))}
                </tbody>
            </Table>

        </div>
    )
}