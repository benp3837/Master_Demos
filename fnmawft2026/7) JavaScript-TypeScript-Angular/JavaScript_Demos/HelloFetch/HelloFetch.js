//URL consts - save some base URLs for cleaner code below
const pokeUrl = "https://pokeapi.co/api/v2/pokemon/"
const zooUrl = "localhost:8080/"


//DOM selection and Event Listener stuff
const name = document.getElementById("name")
const type = document.getElementById("type")
const sprite = document.getElementById("sprite")

//When the button is clicked, get a pokemon
document.getElementById("btn").onclick = fetchData

//USE THE USER'S NAME that we set in localStorage
const username = localStorage.getItem("username")
document.getElementById("header").prepend("Hello " + username + "! ")


/* This function will return some pokemon data from PokeAPI
It's gonna use a fetch() request to return a Promise Object
The Promise Object is going to get filled with pokemon data OR it will fail*/
async function fetchData(){

    //First, gather the user input from the input box
    const userInput = document.getElementById("userInput").value

    //Let's make our Fetch request! (JS Fetch requests are GET requests by default)
    try{

        //Here's the fetch request 
        const response = await fetch(pokeUrl + userInput)

        console.log(response) //just to see

        //If we don't get a 200 OK back, throw an error
        if(response.status !== 200){
            throw error("Pokemon not found!")
        }

        //The Response data is in JSON... we need to translate it to JS
        const data = await response.json() //json() extracts JSON and turns it into JS

        console.log(data) //more meaningful data

        //We're going to outsource frontend rendering to another function
        renderData(data)
    } 
    catch (error){
        alert("Pokemon with ID " + userInput + " Not Found!")
    }

}


//Here's the function that displays pokemon on the screen
//See the call to this on line 39
function renderData(data){

    //Populate the table with pokemon name and type
    name.innerText = data.name
    
    //Type is a little annoying. it's an array of 1 to 2 values
    let types = ""

    for(let value of data.types){
        types += value.type.name + " "
    }

    //finally add the types to the table
    type.innerText = types

    //Add the Pokemon image below
    sprite.setAttribute("src", data.sprites.front_default)

}