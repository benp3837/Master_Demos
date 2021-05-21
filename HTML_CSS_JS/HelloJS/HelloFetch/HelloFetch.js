//PokeAPI endpoint - making a variable to hold the URL is pretty clean looking
const api='https://pokeapi.co/api/v2/pokemon/';

document.getElementById('btn').onclick = getData; //when user clicks the button, execute getData function 

//remember asynch tells a function to return a promise instead of a direct value
async function getData() {
  let userInput = document.getElementById('userInput').value; //put the user input into a variable 

  //document.getElementById('data').innerHTML=''; //???

  //remember await pauses the function until the promise is returned
  let response = await fetch(api+userInput+'/'); //fetch() returns a promise! We assign it to a variable

  if(response.status === 200){ //if the response comes back successfully,
    let data = await response.json(); //parse the response as JSON and turn it into a JS object
    populateData(data); //use that JS object in the method below
  } else {
    document.getElementById('data').innerHTML = "It got away!";
  }
}

//this function will use the JS object to populate the appropriate data on the webpage
function populateData(data) {
  let dataSection = document.getElementById('data'); //this is our empty section element

  let nameTag = document.createElement('h3'); //create a header element 
  nameTag.innerHTML = data.name; //assign the name of the Pokemon to it

  let abilitiesArray = data.abilities; //create an array, assign the abilities to it
  let abilities = document.createElement('ul'); //create an unordered list to hold the abilities

  for(let oneAbility of abilitiesArray){ //enhanced for loop to iterate over the array :o
    let listItem = document.createElement('li'); //create a new list item for each element in array
    listItem.innerHTML = oneAbility.ability.name; //populate list item with the name of the ability 
    abilities.appendChild(listItem); //append the list item to the unordered list
  }

  //Actually populate the section element with the data gathered from the response.
  dataSection.appendChild(nameTag);
  dataSection.innerHTML += 'Abilities<br>'
  dataSection.appendChild(abilities);
}