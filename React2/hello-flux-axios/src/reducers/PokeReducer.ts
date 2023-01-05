import { GET_POKE } from "../actions/ActionTypes";
import { IPoke } from "../store/types";

//remember, reducers help us take in new data from actions, 
//which gets calculated and sent to the store, which holds globally accessible data
let initialState:IPoke = {
    id: 0,
    name:"",
    sprite:null
}

type Action = {type: string, payload: any}

export const PokeReducer = (state:IPoke = initialState, action:Action) => {
    switch(action.type){

        //if the Action type coming in is GET_POKE,
        //the empty Pokemon object in initialState gets replaced with the payload Pokemon
        case GET_POKE:
            initialState = action.payload
            return{
                ...initialState 
                //"property spread notation" (...) in ES6
                //spread the properties of the object out as props
                //saves us a BUNCH of code instead of having to individually assign each value
            }
        default:
            return state
    }
}