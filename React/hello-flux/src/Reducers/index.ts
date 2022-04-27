//this is the root reducer, which we'll fill out after making the User and Post reducer
import { combineReducers } from "redux";
import { userReducer } from "./UserReducer";
import { postReducer } from "./PostReducer";

export default combineReducers({
    user: userReducer,
    posts: postReducer
});