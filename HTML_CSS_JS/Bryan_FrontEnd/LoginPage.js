const url = "http://localhost:8080/auth" //storing the base url in this variable for cleaner code below

//when the user clicks the register button, execute the register method (using an eventListener)
document.getElementById("loginButton").onclick = login;

//when the user clicks the register button, execute the register method (using an eventListener)
document.getElementById("registerButton").onclick = register;


async function login(){

    //put the user's inputs into a variable (using .value)
    let username = document.getElementById("username").value
    let password = document.getElementById("password").value

    let loginDTO = {
        username:username,
        password:password
    }

    await fetch(url + "/login", {
        method: "POST", //send a POST request (would be GET if we didn't specify)

        headers: {"Content-Type": "application/json"}, //specify a return type of JSON

        body: JSON.stringify(loginDTO) //turn our loginDTO object into JSON to send in the request body
    })

    .then((response) => response.json()) //extract the body of the HTTP response from the API
    .then((data) => { //this "data" variable gets the JS version of the incoming JSON.

        console.log(data.accessToken) //This is our JWT!

        //Store our JWT in a local cookie 
        //(one of many ways to make it visible across JS files)
        document.cookie = data.accessToken; 
        console.log("Cookie: " + document.cookie)


        //we need the translated (parsed) JWT in order to determine Student vs Teacher
        console.log(parseJwt(data.accessToken)) 

        //now, we can determine if the user is a teacher or student, and send them to the right page!
        if(parseJwt(data.accessToken).aud == "[Teacher]"){
                window.location.href = "TeacherPage.html"
        } else{

        }
    }) 
    .catch((error) => document.getElementById("header").innerHTML = "Login Failed - Try Again.")
    .finally(() => 
        setTimeout(() => document.getElementById("header").innerHTML = "Welcome to the Course Management System!", 2000))

    /* .then() lets us perform actions with the incoming HTTP Request
       .catch() lets us catch errors and handle them
       .finally() lets us execute some functionality after the other methods complete 
       I threw in a setTimeout(), which lets us execute some code AFTER a given amount of milliseconds
       */

}



//To accomplish register, the user will have to fill in the relevant fields (2 names, username, password)
//the relevant fields will then get combined into one object to send in the body of an HTTP request
async function register(){
    alert("I would take in an object that reflects a RegisterDTO, and send it to the backend")
}


//I didn't write this. It's a standard JWT parser, which should give us our payload (important user info)
function parseJwt (token) {
    var base64Url = token.split('.')[1];
    var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    var jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
}