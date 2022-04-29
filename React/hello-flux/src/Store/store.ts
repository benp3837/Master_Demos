import { applyMiddleware, createStore } from "redux";
import { configureStore } from "@reduxjs/toolkit";
import thunk from "redux-thunk";

import reducer from '../Reducers';

import { AppState } from "./types";

//the initial state of the application in the store will have a default user with no posts
const initialState:AppState = {
    user: {
        username: '',
        password: '',
    },
    posts: []
};

const middleWare = [thunk];

export const store = createStore(reducer, initialState, applyMiddleware(...middleWare));