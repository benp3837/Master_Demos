//this is the file where actual business logic will occur, including calls to an api (server)
import {ADD_USER, LOGIN_USER} from './actionTypes';
import {IUser} from '../Store/types';
import axios from 'axios';


interface UserReg {
    firstName: string,
    lastName: string,
    email: string,
    username: string,
    password: string
}

interface UserLogin {
    username: string,
    password: string
}

export const newUser = (user:UserReg) => async (dispatch:any) => {
    //some registration logic would go here
}

//we send in an object of type UserLogin, since that's what we're sending in our POST
export const loginUser = (user:UserLogin) => async (dispatch:any) => {
    
    console.log(user.username)
    console.log(user.password)

    let loggedIn: IUser;
    try {
        const res = await axios.post('http://localhost:5000/login', user);
        loggedIn = {
            username: res.data.username,
            password: res.data.password
        }
        
        console.log(loggedIn.username + " in loginUser")

        return dispatch({
            type: LOGIN_USER,
            payload: loggedIn
        });

    } catch(e){
        
        loggedIn = {
            username: '',
            password: ''
        }

        return dispatch({
            type:LOGIN_USER,
            payload:user
        });
    }
}