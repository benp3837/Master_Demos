const url = "http://localhost:8080"

document.getElementById("createCourseButton").onclick = createCourse

//GET ALL COURSES
//Thanks to window.onload, this functionality will be invoked as soon as the page loads.
window.onload = async function() {
    
    //we will send a fetch request to get all courses. by default, fetch requests send GET requests 
    await fetch(url + "/courses") //, {credentials: "include"}
    
    .then((response) => response.json()) //extract the body of the HTTP response from the API
    .then((data) => { //this "data" variable gets the JS version of the incoming JSON.
    
        //log the actual course data that's been parsed from JSON (good for debugging)
        console.log(data);

        //For every Course object we get back from our fetch request, put it in the table
        for(let course of data){

            //create a table row
            let row = document.createElement("tr");

            //create a data cell for each course field
            let cell = document.createElement("td");
            //fill the cell with the appropriate course data
            cell.innerHTML = course.id;
            //add the td element (data cell) to the tr element (table row)
            row.appendChild(cell);

            //we do this^^^^ for every column in courses

            let cell2 = document.createElement("td");
            cell2.innerHTML = course.name;
            row.appendChild(cell2);

            let cell3 = document.createElement("td");
            cell3.innerHTML = course.description;
            row.appendChild(cell3);

            let cell4 = document.createElement("td");
            cell4.innerHTML = course.credits;
            row.appendChild(cell4);

            //append the tr (which we called "row") to the table body (tbody)
            //a new row will be appended FOR every course that got returned in the fetch()
            document.getElementById("tableBody").appendChild(row);

        }
        //so here, for every employee object, we create a new row, fill it with data, add it to table
    
    })
    .catch((error) => {
        alert("uh oh your session is inactive. Maybe not logged in? :/")
        console.log(error)
    });

} //end of get courses


//CREATE COURSE
async function createCourse(){

    //put the user's inputs into a variable (using .value)
    let name = document.getElementById("courseName").value
    let description = document.getElementById("courseDesc").value
    let credits = document.getElementById("courseCreds").value

    //create the course object to send to the API
    let newCourse = {
        name:name,
        description:description,
        credits:credits
    }

    await fetch(url + "/courses", {
        method: "POST", //send a POST request (would be GET if we didn't specify)

        headers: {
            "Content-Type": "application/json", //specify a return type of JSON
            "Authorization": "Bearer " + document.cookie //we need the JWT for this request
            }, 

        body: JSON.stringify(newCourse) //turn our loginDTO object into JSON to send in the request body
    })

    .then((response) => response.json()) //extract the body of the HTTP response from the API
    .then((data) => { //this "data" variable gets the JS version of the incoming JSON.

        console.log(data) //check what gets returned

        alert("Course Created!")

    }) 
    .catch((error) => {alert("failed to create course: " + error)})

    } //end of create course


document.getElementById("printJWTButton").onclick = getJWT


function getJWT(){
    console.log(document.cookie)
}



