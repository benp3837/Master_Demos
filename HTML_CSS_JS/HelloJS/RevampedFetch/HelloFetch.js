//PokeAPI base URL - making a variable to hold the base URL, which will make for cleaner code
//we will append an endpoint based on the user input
const api = "https://pokeapi.co/api/v2/pokemon/"

//Get the 5 HTML elements that I want to populate with data (Dom Selection)
let pokename = document.getElementById("pokename");
let poketype = document.getElementById("poketype");
let pokenum = document.getElementById("pokenum");
let pokepic = document.getElementById("pokepic");

//when the user clicks the button, execute the fetchData function
document.getElementById("btn").onclick = fetchData
//this is a cleaner way to add an event listener to an element

//compare this function to the ajaxFunc() in HelloAjax... this is much cleaner

//This function will return our pokemon data
//It will use the Fetch api to return a promise object
//This promise object will get filled with data for the pokemon we requested
async function fetchData(){

    //put the user input into a variable
    let userInput = document.getElementById("userInput").value

    //use the fetch() method to send a request to the PokeAPI with the user's input
    //await pauses the function until the promise completes (when it's returned (success) or rejected (error))
    //fetch sends a GET request by default. this one takes our base URL plus the user's input
    await fetch(api + userInput)
    .then((response) => response.json()) //extract the body of the request
    .then((data) => renderHTML(data)) //send the data from the request body to our renderHTML function
    .then(() => document.getElementById("header").innerHTML = "Pokemon Found!")
    .catch((error) => document.getElementById("header").innerHTML = "It got away! Try again...")
    .finally((response) =>
        setTimeout(() => document.getElementById("header").innerHTML = "Find A Pokemon:", 2000)
        )

    /* .then() lets us perform actions with the incoming HTTP Response
       .catch() lets us provide error handling code
       .finally() lets us execute some functionality after the other methods complete
       I threw in a setTimeout() here! What's that? it executes come code after a given amount of milliseconds. 
    */
    
}

//this function will manipulate the DOM based on the user's input & response from the server
function renderHTML(data) {

    console.log(data); //to see the data you're working with

    //populate the previously empty HTML elements with pokemon data
    pokename.innerText = data.name
    pokenum.innerText = data.id 
    poketype.innerText = data.types[0].type.name
    //we want to check if there's a second type, and render it if so
    if(data.types[1]){
        poketype.innerText += (" & " + data.types[1].type.name) 
    }

    //pokepic will be a little different, we need to set the src attribute of the <img> tag
    pokepic.setAttribute("src", data.sprites.front_default)

 }


/* hypothetical function that would send a POST request (a bit more involved than GET, since we're sending data)

await fetch(url + "/pokemon", {
        method: "POST", //send a POST request (would be a GET if we didn't specify)
        body: JSON.stringify(pokemonObject), //turning a pokemon object into JSON to send in the request body
    })
    .then(stuff)
    .catch(other stuff)
    .finally(wow even more stuff)

*/