import axios from "axios"
import { useEffect, useState } from "react"
import { useNavigate } from "react-router-dom"
import { UserInterface } from "../../interfaces/UserInterface"
import { User } from "./User"
import { store } from "../../globalData/store"

export const UsersContainer: React.FC<any> = ({users:any}) => {

    //useState hook, which will store an Array of Users (to send to the User Component)
    const [users, setUsers] = useState<UserInterface[]>([])

    //need this to navigate between URLS
    const navigate = useNavigate()

    //useEffect to GET the List of User upon component render and do a route check
    useEffect(()=>{

        console.log("role: " + store.loggedInUser.role )

        if(store.loggedInUser.role !== "admin"){
            navigate("/")
        } else {
            getAllUsers()
        }
    }, [])

    //function to get all users from the DB
    const getAllUsers = async () => {

        const response = await axios.get("http://localhost:8080/users", {
            headers: {
                'Authorization': `Bearer ${store.loggedInUser.jwt}`
            }
        })
        .then(
            (response) => {
                console.log(response.data)
                setUsers(response.data) 
                //now we have users state we can send to the User component
            }
        )

    }

    return(
        <div>
            <button onClick={()=>navigate("/cars")}>See Your Cars</button>
            <User users={users}></User>
        </div>
    )

}