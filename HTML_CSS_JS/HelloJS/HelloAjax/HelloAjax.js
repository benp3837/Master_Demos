//Get (by id) the HTML elements to be populated 
let pokenum = document.getElementById("pokenum");
let pokename = document.getElementById("pokename");
let poketype = document.getElementById("poketype");
let pokepic = document.getElementById("pokepic");

//set event listener for button click
let button = document.getElementById('btn');
button.addEventListener("click", ajaxFunc);

//this function will 
function ajaxFunc(){
    let num = document.getElementById('userInput').value; //gather the user's input

    let xhr = new XMLHttpRequest(); //the object that sends/recieves data

    //this functionality will execute every time the event fires (since readystate changes)
    xhr.onreadystatechange = function () {

        //if response is ready && if status = OK.
        if(this.readyState===4 && this.status===200){

        //this takes the JSON we get back and puts it into a JS object
        let data = JSON.parse(xhr.responseText);

        //see method below - takes our data variable and changes the HTML accordingly
        renderHTML(data);
        } 
    }

    //open(method, URL, async) - opens a certain resource on the web
    xhr.open("GET", "https://pokeapi.co/api/v2/pokemon/"+num, true);
    xhr.send(); //send the request to the server
}

    //this function will manipulate the DOM based on the user's input & the response from the server
    function renderHTML(data) {
        pokepic.setAttribute("src", data.sprites.front_default); //remember to "find" this
        //populate the previously empty text held by the elements
        pokenum.innerText = data.id;
        pokename.innerText = data.name;
        poketype.innerText = data.types[0].type.name;
        if(data.types[1]){
            poketype.append(", " + data.types[1].type.name);
        }



        //lastly, this will print out to the console telling us the data we gathered
        console.log("Pokemon Found:")
        console.log("ID: " + data.id);
        console.log("Name: " + data.name);
    }

