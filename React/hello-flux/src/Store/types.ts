//creating a few interfaces for the global store
export interface IUser {
    username: string,
    password: string
}

export interface IPost {
    id: number,
    username: string,
    content: number,
    likes?: number //the ? means
}

export type AppState = {
    user: IUser, //one user object
    posts: IPost[] //an array of posts
}