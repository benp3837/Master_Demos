import axios from "axios";
import React, { useEffect, useState } from "react"
import { useNavigate } from "react-router-dom"

import "./Login.css"

export const Login: React.FC<any> = () => {

    //temporary variable to hold a logged in user
    let loggedInUser = {
        id:0,
        username:"",
        password:""
    }

    //useState hooks to declare a state object, a mutator (which changed state), and a default value
    let [username, setUsername] = useState('');
    let [password, setPassword] = useState('');

    //we'll use this object to switch components whenever appropriate
    //this is what lets us navigate through the application through button clicks, etc.
    const navigate = useNavigate();

    //when user updates the username/password field, this function is called
    //when user updates the values, username OR password get updated as well
    //this is how we can send a username/password object to the loginUser Action
    const handleChange = (input:any) => {
        if(input.target.name === "username"){ //if the input is name=username...
            setUsername(input.target.value) //set username to be the value that was inserted
            console.log(username) //to show useState working
        } else {
            setPassword(input.target.value) //otherwise, set the password with that value.
        }
    }

    const login = async () => {

        //send my HTTP POST request with axios, and put it into a variable we can use
        const response = await axios.post('http://localhost:5000/auth', {username, password});

        if(response.status === 202) { //if the login was successful...
            
            console.log(response) //to see the data coming back

            //populate our loggedInUser variable based on the data sent back from the server
            loggedInUser = {
                id: response.data.id,
                username: response.data.username,
                password: response.data.password
            }

            if(loggedInUser.id > 0){
                navigate("/home"); //thanks to Routing in the App.tsx, this will switch the component.
            }
        }
    }

    return(
        <div className="login">

            <div className="text-container">
                <h1>Welcome to PokeMart!</h1>
                <h3>Sign in to browse for a pokemanz</h3>

                <div className="input-container">
                    <input type="text" name="username" placeholder="username" onChange={handleChange}/>
                </div>
                <div className="input-container">
                    <input type="password" name="password" placeholder="password" onChange={handleChange}/>
                </div>

                <button className="login-button" onClick={login}>Catch 'em all!</button>
            </div>

            <div className="disclaimer">
                <p>PokeMart© and its affiliates do not condone the misuse or mistreatment of pokemon</p>
            </div>

        </div>
    )

} 