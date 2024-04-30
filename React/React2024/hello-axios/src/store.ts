/* This is a rudimentary implementation of a store, which is basically global storage
any data that you want to store globally (visible to the entire app) can reside here
look into context API to see a more sophisticated use of a store, but be warned it's dense*/

//I'm calling this "state" because I think of the store as a global state of the entire app
 export const state:any = {
    JWT:"",

    //this is an example of how you might store User info (after parsing the JWT)
    userSessionData: {
        userId:0,
        username:"",
    },

    //maybe you want to store an Array of all the user pokemon (won't do this)
    pokemon:[]

    //Don't just copy me though! think about your requirements
    //if you only need accounts in one component, no need to globally store it.
    //if you need data accessible between multiple components, it should probably be globally stored.
 }

 //these defaults will all get populated after the user triggers population 
 //typically, all of the data the user needs gets populated on login, but it's case by case
 //in this demo, we're only going to be populating the JWT. see login().