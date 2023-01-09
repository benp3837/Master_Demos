import { ADD_POKE, GET_POKE } from "../actions/ActionTypes";
import { IPoke } from "../store/types";

//remember, reducers help us take in new data from actions and sending that data to the store
//this is the user reducer, which will help us calculate changes in the current User
let initialState:IPoke = {
    id: 0,
    name:"",
    sprite:null
}

//this is an object that will determine what action to take below
type Action = {
    type: string, 
    payload: any
}

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
        case ADD_POKE:
            //add pokemon stuff would go here
            break;
        default:
            return state
            //if none of the cases are matches, return the unchanged state
    }
}