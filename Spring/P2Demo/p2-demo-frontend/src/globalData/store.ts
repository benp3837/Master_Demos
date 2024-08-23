/* This is a rudimentary implementation of a store, which is basically global data storage 

Any data that you want to stroe globally (visible to the entire app) can reside here
look into the Context API to see a more industry standard way of doing this (we'll see it later) */

import { UserInterface } from "../interfaces/UserInterface";

export const store:any = {

    //we typically want to store user session info on the front end
    //...for the sake of personalization, role-based behavior, and easier HTTP requests
    loggedInUser: {
        userId:0,
        username:"",
        role:"",
        jwt:""
    } as UserInterface, 
    //NOTE: we could have made a UserInterface (and I might still)

    //Think about your requirements when it comes to storing global data
    //you only NEED to globally store data you intend to use in multiple contexts

    //for instance, we could have stored the base URL to our backend
    baseURL: "http://localhost:8080/"

    //In p2, we'll store our JWT tokens here to be included in requests to 

    //We could have even stored the User's Car List after the first get all to avoid repeat calls the DB
        //(Check if it exists in the store first, before sending the HTTP requests)

}