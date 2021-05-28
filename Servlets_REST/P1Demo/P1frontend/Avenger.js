const url = 'http://localhost:8080/P1Demo/'; //you can probably grab this from postman
//Eventually we'll be making calls to this server and adding our own endpoints to it

//let's add an event listener to give functionality to our button
document.getElementById("getAvengerButton").addEventListener('click', assembleFunc);
//so when this button gets clicked, the function called assembleFunc will run
//we could have also used docment.getElementById("getAvengerButton").onClick(assembleFunc);

//this function will return all of our avengers
async function assembleFunc(){ //remember async returns a promise
    //here we send a fetch request to get our avenger data
    //await makes the async function wait until the promise returns with the fetched data
    let response = await fetch(url + 'avengers'); 

    if(response.status === 200){ //if request is successful
        console.log(response); //just so we can see the response
        let data = await response.json(); //get the json data from the response 
                                          //and turn it into an object (an array in this case)

        //now I want to put each avenger into my table
        for(let avenger of data){ //for every avenger in the data variable...
            console.log(avenger); 
            console.log(typeof data);
            let row = document.createElement("tr");

            let cell = document.createElement("td"); //create the cell
            cell.innerHTML = avenger.av_id; //fill the cell with avenger data
            row.appendChild(cell); //this row now has the first cell (av_id)
            
            //then we'll do that for each field in the avenger model
            let cell2 = document.createElement("td");
            cell2.innerHTML = avenger.av_name;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = avenger.av_power;
            row.appendChild(cell3);

            let cell4 = document.createElement("td");
            cell4.innerHTML = avenger.first_name;
            row.appendChild(cell4);

            let cell5 = document.createElement("td");
            cell5.innerHTML = avenger.last_name;
            row.appendChild(cell5);

            let cell6 = document.createElement("td");
            cell6.innerHTML = avenger.power_level;
            row.appendChild(cell6);

            //if the avenger has a home, just fill the cell with the home name
            if(avenger.home != null){
                let cell7 = document.createElement("td");
                cell7.innerHTML = avenger.home_fk.homeName;
                row.appendChild(cell7);
            } else { //otherwise just fill it with an empty value
                let cell7 = document.createElement("td");
                row.appendChild(cell7);
            }

            document.getElementById("avengerBody").appendChild(row);
            //so the variable "row" we created alllll the way at the top of the for loop 
            //will be appended to our empty table body in the HTML

        }
    }
}
