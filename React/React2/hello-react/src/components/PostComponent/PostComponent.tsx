import React, { useEffect, useState } from "react";
import { UserInterface } from "../../interfaces/UserInterface";

//import the CSS file we'll style this component with
import "./PostComponent.css";

/*
export CONST instead of export class. This is a function component, not a class component.
recall how lambdas/arrow functions work: they take in some data, and execute some code.
in this case, we take in a UserInterface as props to use in this function.
*/
export const PostComponent: React.FC<UserInterface>=(user:UserInterface) => {

    //this variable is cool, but it's not part of state. We couldn't send this to other components
    let coolVar:string = "I can't be inherited :("

    /* Below we will see two types of variable management in Function Components:
    -Destructuring, which is how we declare variables from props
    -useState, which lets us declare state */
    
    /*Destucturing
    We're breaking apart the user object that was passed in from props
    In this case, we're taking its username variable and turning it into a local variable we can use
    the name inside the curly braces must match a variable in the prop that was sent in*/    
    const {username} = user; 
    const {email} = user; //lets grab the email too

    /*useState 
    Allows us to store and manipulate state. 
    We declare a variable, a mutator function, and a default value within the useState...
    So now, we can change the value of the "content" variable with the setContent() function. */
    let [content, setContent] = useState('');

    /*useEffect 
    Allows us to execute some code at certain events in the component's life
    This can be anything from button clicks, to state change, to simply rendering the component
    useEffect is a function component's version of the componentDidMount lifecycle method */
    useEffect(() => {
        //for now, we'll use useEffect to call our useState mutators
        setContent("We are setting this text with useState in the useEffect hook")
    }, []) //empty square brackets because we want this useEffect to happen when the component renders

    //return(), not render(), since this is a function component.
    return(
        <div className="post-container">
            <div className="profile-container">
                <img className="profile-pic" src='https://t4.ftcdn.net/jpg/00/64/67/63/360_F_64676383_LdbmhiNM6Ypzb3FM4PPuFP9rHe7ri8Ju.jpg' alt='pic'/>
                <h2 className="profile-username">{username}</h2>
            </div>

            <div className="content-container">
                <h5>{username} says:</h5>
                <p>{content}</p>
            </div>
        </div>
    )

}