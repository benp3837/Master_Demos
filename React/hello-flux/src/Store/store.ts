import { applyMiddleware, createStore } from "redux";
import { configureStore } from "@reduxjs/toolkit";
import thunk from "redux-thunk";

import reducer from '../Reducers';

import { AppState } from "./types";

//the initial state of the application in the store will have a default user and empty poke
const initialState:AppState = {
    user: {
        username: 'test',
        password: '',
    },
    poke: {
        id: 0,
        name: '',
        sprite: null
    }
};

export const store = configureStore({
    reducer
});