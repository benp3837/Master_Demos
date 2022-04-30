import React, {useState, useEffect} from "react";
import {useDispatch, useSelector} from "react-redux";
import { loginUser } from "../../Actions/UserActions";
import { useNavigate, Link} from "react-router-dom";

import './Login.css'

export const Login: React.FC<any> = () => {

    const appState = useSelector<any, any>((state) => state);

    //we use a dispatcher to send new data to the store
    const dispatch = useDispatch();

    //we'll use this object to switch components - essentially to NAVIGATE through our app
    const navigate = useNavigate();

    //username and password here correlate to "username" and "password" in the render() function
    let [username, setUserName] = useState('');
    let [password, setPassword] = useState('');

    //when user updates the username/password fields, save the value to the variables above
    const handleChange = (e:any) => {
        if(e.target.name === 'username') {
            console.log("handleChange: " + e.target.value)
            setUserName(e.target.value);
        } else {
            setPassword(e.target.value);
        }
    }

    //this gets called when the login button is pushed.
    //it sends the saved username and password to the loginUser in UserActions.ts
    const login = async () => {
        console.log("in login")
        //send this new data to the store
        await dispatch(
            loginUser({username, password}) as any
        );
    console.log(username)
    }

    //this code runs when appState changes
    useEffect(() => {
        console.log(appState);
        console.log("in useEffect");
        if(appState.user.username === "trainer"){
            console.log(appState.user.username)
            navigate("/home");
        }
    }, [appState]);

    return(
        <div className="login">
             <img className="ball" src={process.env.PUBLIC_URL+"pokeball.png"} alt="hello?"/>
            <div className="text-container">     
                <h1 className="login-h1">Welcome to PokeMart!</h1>
                <h2>Sign in to browse Pokemanz!</h2>
            </div>
            <form className="login-form">
                <div className="input-div">
                <input autoComplete="off" className="login-input" type="text" name="username" placeholder="Username" onChange={handleChange}/>
                </div>
                <div className="input-div">
                    <input className="login-input" type="password" name="password" placeholder="Password" onChange={handleChange}/>
                </div>
            </form>
            <button className="login-button" onClick={login}>Login</button>
        </div>
    );

}