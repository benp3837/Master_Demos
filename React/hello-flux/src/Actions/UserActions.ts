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

     console.log(user.username);
     console.log(user.password);

    try{
        let res = await axios.get("https://pokeapi.co/api/v2/pokemon/torchic");
        console.log(res.data);
        return dispatch({
            type: GET_POKE,
            payload: res.data
        });
    } catch (e) {
        console.log("naurrrr");
        return dispatch({
            type: GET_POKE,
            paylod: []
        })
    }
}