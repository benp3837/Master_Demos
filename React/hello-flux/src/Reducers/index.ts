//this is the root reducer, which we'll fill out after making the User and Post reducer
import { combineReducers } from "redux";
import { userReducer } from "./UserReducer";
import { pokeReducer } from "./PokeReducer";

export default combineReducers({
    user: userReducer,
    poke: pokeReducer
});