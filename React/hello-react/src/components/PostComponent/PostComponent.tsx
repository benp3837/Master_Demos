//useEffect and useState?
import React, {useEffect, useState} from "react";
import { UserInterface } from "../../interfaces/UserInterface";

//import CSS file that we'll style this component with

//note export CONST instead of export CLASS. This is a FUNCTIONAL component (not a class component)
export const PostComponent: React.FC<UserInterface>=(user:UserInterface) => {

    //you need to take some notes so that you can accurately comment this part

    const {username} = user;

    let [userName, setUserName] = useState('');
    let [content, setContent] = useState('');

    useEffect(() => {
        setUserName(username);
        setContent("We are setting this text in the useEffect function");
    }, [])

    return(
        <div className="post-container">
            STILL DOING STUFF HERE
        </div>
    );

}