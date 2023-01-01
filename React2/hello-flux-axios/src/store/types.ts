//this file stores interfaces for all types (objects) we will need

//declaring some types with default values as interfaces
export interface IUser {
    id: number;
    username: string;
    password: string;
}

export interface IPoke {
    id: number;
    name: string;
    sprite: any; 
}

//AppState object that will store one of each interface.
//note the type keyword... it's like calling something an object in java
export type AppState = {
    user: IUser, //one empty user object
    poke: IPoke //one empty poke object
}
//separating values by commas here, because AppState is an object not an interface