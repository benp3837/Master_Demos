//useEffect and useState, which are hooks that we'll use below
import React, {useEffect, useState} from "react";
import { UserInterface } from "../../interfaces/UserInterface";

//import the CSS file that we'll style this component with
import './PostComponent.css';

//export CONST instead of export CLASS. This is a FUNCTIONAL component (not a class component)
//remember how lambdas/arrow functions work. They take in some data, and execute some code
export const PostComponent: React.FC<UserInterface>=(user:UserInterface) => {

    //you need to take some notes so that you can accurately comment on this part

    //destructuring - we're breaking apart the prop we passed into the component, into a variable
    //we're going to databind it in the return() below
    const {username} = user;

    //useState allows you to store and manipulate state 
    //you declare a state variable, and a mutator function, and a default value within the useState
    let [userName, setUserName] = useState('');
    let [content, setContent] = useState('');

    //useEffect allows you to execute some code at certain points in the application's life
    //in this case, the code will execute when the component initializes.
    useEffect(() => {
        setUserName(username);
        setContent("We are setting this text in the useEffect function");
    }, [])

    //Every Functional Component has the return() method, where we put the JSX/TSX to be rendered
    return(
        <div className="post-container">
            <div className="post-profile">
                <img className="post-image" src='https://t4.ftcdn.net/jpg/00/64/67/63/360_F_64676383_LdbmhiNM6Ypzb3FM4PPuFP9rHe7ri8Ju.jpg' alt='hey'/>
                <h3 className="post-username">{userName}</h3>
            </div>

            <div className="post-content">
                <p>{content}</p>
            </div>
        </div>
    );

}