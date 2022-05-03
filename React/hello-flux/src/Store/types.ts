//creating a few interfaces for the global store
export interface IUser {
    id: 0,
    username: string,
    password: string
}

export interface IPoke {
    id: number,
    name: string,
    sprite: any
}

export type AppState = {
    user: IUser, //one empty user object
    poke: IPoke //one empty pokemon object
}