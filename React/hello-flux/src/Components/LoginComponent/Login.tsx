import React, {useState} from "react";
import {useDispatch, useSelector} from "react-redux";
import { loginUser } from "../../Actions/UserActions";
import { useNavigate, Link } from "react-router-dom";
import './Login.css'

export const Login: React.FC<any> = () => {

    const appState = useSelector((state) => state);
    const dispatch = useDispatch();

    const history = useNavigate();

    let [username, setUserName] = useState('');
    let [password, setPassword] = useState('');

    const handleChange = (e:any) => {
        if(e.target.name === 'username') {
            setUserName(e.target.value);
        } else {
            setPassword(e.target.value);
        }
    }

    const login = async () => {
        await dispatch(
            loginUser({username, password}) as any
        );
    }

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