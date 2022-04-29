//this is the file where actual business logic will occur, including calls to an api (server)
import {GET_POKE, ADD_USER, LOGIN_USER} from './actionTypes';
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

export const loginUser = (user:UserLogin) => async (dispatch:any) => {
    //some login logic would go here

    //create a variable of type IUser

    //try a fetch that calls some login functionality, save the returned user here. 

    //catch(e) {
        //alert("it aint work");
    //}
    
    console.log(user.username)
    console.log(user.password)

    let loggedIn: IUser;
    try {
        const res = await axios.post('http://localhost:5000/login', user);
        loggedIn = {
            username: res.data.username,
            password: res.data.password
        }
        
        console.log(loggedIn)

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