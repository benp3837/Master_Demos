//creating a few interfaces for the global store
export interface IUser {
    username: string,
    password: string
}

export interface IPoke {
    id: number,
    name: string,
    sprite: any
}

export type AppState = {
    user: IUser, //one user object
    poke: IPoke //one pokemon object
}