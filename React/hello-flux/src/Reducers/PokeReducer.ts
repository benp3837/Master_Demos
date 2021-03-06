import { GET_POKE } from "../Actions/actionTypes";
import { IPoke } from "../Store/types";

let initialState:IPoke = {
    id: 0,
    name: '',
    sprite: null
};

type Action = {type: string, payload: any}

export const pokeReducer = (state:IPoke = initialState, action:Action) => {
    switch(action.type){
        case GET_POKE:
            initialState = action.payload;
            console.log(action.payload.name + " in pokeReducer");
            console.log("poke in reducer is: " + initialState.name)
            return {
                ...initialState
            }
        default:
            return state
    }
}