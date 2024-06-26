import React, { useEffect, useState } from "react";
import { UserInterface } from "../../interfaces/UserInterface";
import "./PostComponent.css"

//This component has props of UserInterface, so it can only accept UserInterface objects from a parent
export const PostComponent: React.FC<UserInterface> = (user:UserInterface) => {

    /*Another way to accomplish Destructuring - In the code 
    Destructuring lets us break up a props object into individual variables 
    The name inside the curly braces must match the variable in the props that was sent in */
    const {username} = user
    const {email} = user
    //we could have also grabbed the firstName and lastName value from the user in this way


    /* useState and useEffect - two lifecycle hooks */

    /*useState allows us to store and manipulate state
    We declare a variable to access state, a mutator (similar to a setter) to change it, and a default value within the actual useState()
    So now, we can access and change state */
    let[post, setPost] = useState('')

    /* useEffect allows us to execute some code when a certain event happens (we specify the event)
    Similar to how eventListeners work. This can be button clicks, page loads, mouseover, etc.*/
    useEffect(() => {
        //we'll use the useEffect to call our useState mutator when the component loads
        setPost("Thanks to useEffect, post content was set via useState on page load")
    }, []) //empty square brackets because we want this useEffect to happen on component load



    //in function components, we only need return(), no render()
    return(
        <div className="post-container">
            <div className="profile-container">
                <img className="profile-pic" src="https://t4.ftcdn.net/jpg/00/64/67/63/360_F_64676383_LdbmhiNM6Ypzb3FM4PPuFP9rHe7ri8Ju.jpg" alt="PROFILE PIC" />
                <h4 className="profile-username">{username}</h4>
            </div>

            <div className="content-container">
                <h5>{username} says:</h5>
                <p>{post}</p>
            </div>
        </div>
    )

}
