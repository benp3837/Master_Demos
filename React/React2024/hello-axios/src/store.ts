/* This is a rudimentary implementation of a store, which is basically global storage
any data that you want to store globally (visible to the entire app) can reside here
look into context API to see a more sophisticated use of a store, but be warned it's dense*/

import { PokemonInterface } from "./interfaces/PokemonInterface";
import { UserInterface } from "./interfaces/UserInterface";

//I'm calling this "state" because I think of the store as a global state of the entire app
 export const state:any = {
    JWT:"",

    //this is an example of how you might store User info (after parsing the JWT)
    userSessionData: {
        userId:0,
        username:"",
        //status:""
    } as UserInterface,

    //maybe you want to store the last caught pokemon for display
    lastCaughtPokemon: {
        name:"",
        image:""
    } as PokemonInterface

    //Think about your requirements
    //you only NEED to globally store data that you intend to use across multiple components!!
    //but you could optimize your code by using global storage to reduce calls to your DB
 }

 //typically, all of the data the user needs gets populated on login, but it's case by case
 //in this demo, we're only going to be populating the JWT. see login().