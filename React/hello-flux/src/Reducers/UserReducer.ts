import { IUser } from "../Store/types";
import { LOGIN_USER } from "../Actions/actionTypes";
//we will import our action types here

let initialState:IUser = {
        username: '',
        password: '',
};

type Action = {type: string, payload: any};

export const userReducer = (state: IUser = initialState, action:Action) => {
    switch(action.type){
        case LOGIN_USER:
            initialState = action.payload;
            console.log(action.payload.username + " in userReducer");
            return {
                ...initialState,
            }
        default:
            return state;
    }
}