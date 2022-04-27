import { IUser } from "../Store/types";
//we will import our action types here

const initialState:IUser = {
        id:0,
        firstName: '',
        lastName: '',
        email: '',
        username: '',
        password: '',
};

type Action = {type: string, payload: object};

export const userReducer = (state: IUser = initialState, action:Action) => {
    switch(action.type){
        default:
            return state;
    }
}