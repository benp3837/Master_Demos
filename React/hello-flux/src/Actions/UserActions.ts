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

//this models the user login creds that will be sent in the POST request 
interface UserLogin {
    username: string,
    password: string
}

export const newUser = (user:UserReg) => async (dispatch:any) => {
    //some registration logic would go here
}

//we send in an object of type UserLogin, since that's what we're sending in our POST
export const loginUser = (loginCreds:UserLogin) => async (dispatch:any) => {
    
    console.log(loginCreds.username)
    console.log(loginCreds.password)

    let loggedIn: IUser;
    try {
        const res = await axios.post('http://localhost:5000/login', loginCreds);
        
        if(res.status === 202){
        
            loggedIn = {
                id: res.data.id,
                username: res.data.username,
                password: res.data.password
            }
            
            console.log(loggedIn.username + " in loginUser")

            return dispatch({
                type: LOGIN_USER,
                payload: loggedIn
            });
        } 
    } catch(e){
        
        console.log("USER LOGIN FAILED!!")

        loggedIn = {
            id: 0,
            username: '',
            password: ''
        }

        return dispatch({
            type:LOGIN_USER,
            payload:loggedIn
        });
    }
}