//useEffect and useState?
import React, {useEffect, useState} from "react";
import { UserInterface } from "../../interfaces/UserInterface";

//import the CSS file that we'll style this component with
import './PostComponent.css';

//note export CONST instead of export CLASS. This is a FUNCTIONAL component (not a class component)
export const PostComponent: React.FC<UserInterface>=(user:UserInterface) => {

    //you need to take some notes so that you can accurately comment on this part

    const {username} = user;

    let [userName, setUserName] = useState('');
    let [content, setContent] = useState('');

    useEffect(() => {
        //this 
        setUserName(username);
        setContent("We are setting this text in the useEffect function");
    }, [])

    return(
        <div className="post-container">
            <div className="post-profile">
                <img className="post-image" src='https://t4.ftcdn.net/jpg/00/64/67/63/360_F_64676383_LdbmhiNM6Ypzb3FM4PPuFP9rHe7ri8Ju.jpg'/>
                <h3 className="post-username">{userName}</h3>
            </div>

            <div className="post-content">
                <p>{content}</p>
            </div>
        </div>
    );

}