//again, business logic will go here for functionality pertaining to posts
import axios from "axios";
import { GET_POSTS, ADD_POST, GET_POKE } from "./actionTypes";

interface NewPost{
    userId: number,
    content: string
}

export const addPost = (post:NewPost) => async (dispatch:any) => {
    //new post logic would go here
}


export const getPosts = () => async (dispatch:any) => {
    //get posts logic would go here
}
export const getPoke = () => async (dispatch:any) => {
    try{
        let res = await axios.get("https://pokeapi.co/api/v2/pokemon/mudkip");
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