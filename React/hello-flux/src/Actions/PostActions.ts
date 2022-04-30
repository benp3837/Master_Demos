//again, business logic will go here for functionality pertaining to posts
import axios from "axios";
import { GET_POSTS, ADD_POST, GET_POKE } from "./actionTypes";
import { IPoke } from '../Store/types'

interface newPoke{
    id: number,
    name: string
}

//maybe some kind of logic to add a poke to your team
export const addPoke = (post:newPoke) => async (dispatch:any) => {
    //add new poke logic would go here
}

//no need for parameters, since we're just GETting data
export const getPoke = (pokeID:number) => async (dispatch:any) => {
   
   let incomingPoke: IPoke;
   console.log("pokeID is: " + pokeID)

    try{
        const res = await axios.get("https://pokeapi.co/api/v2/pokemon/" + pokeID);
        console.log(res.data);

        incomingPoke = {
            id: res.data.id,
            name: res.data.name
        }

        console.log("incoming Poke is: " + incomingPoke.name);

        return dispatch({
            type: GET_POKE,
            payload: incomingPoke
        });
    } catch (e) {
        console.log("naurrrr");
        return dispatch({
            type: GET_POKE,
            paylod: []
        })
    }
}

export const getPosts = () => async (dispatch:any) => {
    try{
        let res = await axios.get('http://localhost:8080/SocialHubWeekThree/api/posts');
        console.log(res.data);
        return dispatch({
            type: GET_POSTS,
            payload: res.data
        });
        
    }
    catch(e){
        console.log('uh oh')
        return dispatch({
            type: GET_POSTS,
            payload: []
        });
    }
}
