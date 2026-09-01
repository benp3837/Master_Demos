//This is a TypeScript file - TS is a quirky little language that's like a JS/Java hybrid
//It's a SUPERSET of JavaScript - so all valid JS is valid TS. 
//Lots of similar syntax to JS - look at the console.log
console.log("Hello Typescript - we'll be using you in Angular apps");
//We should strongly type our TypeScript
var greeting = "Hello TypeScript";
//NOT LIKE JS HERE! We care more about typing in TYPEscript. Strict/Strong typing
//greeting = 500
//one TS-exclusive datatype is the "any" datatype
//good for type flexiblity (it can be "any" datatype) 
//but not great for type scrictness, which is a major key to TS
var flexibleVar = 135253;
flexibleVar = "A String now";
flexibleVar = true;
flexibleVar = null;
//Arrays in TS are NOT fixed in size, but can only keep one datatype 
var names = ["Charlie", "Tony", "Paul"];
var anything = ["Whatever", 35235, true];
//We can make Classes in TS, good for holding and modeling data
var Person = /** @class */ (function () {
    //constructor - Every class needs a constructor for us to initialize an object
    function Person(name, motive) {
        this.name = name;
        this.motive = motive;
    }
    //we can have methods too (a method is just a function defined in a class)
    Person.prototype.stateMotive = function () {
        console.log(this.name + " is driven by " + this.motive);
    };
    return Person;
}());
//Instantiate some Persons
var people = [];
for (var _i = 0, names_1 = names; _i < names_1.length; _i++) {
    var name_1 = names_1[_i];
    people.push(new Person(name_1, "Education"));
}
//Call the motive method of each person
for (var _a = 0, people_1 = people; _a < people_1.length; _a++) {
    var person = people_1[_a];
    person.stateMotive();
}


//Account Registration stuff below-------------------------------------

//Set the event listener on the "registerButton"
document.getElementById("registerButton")?.addEventListener("click", registerUser)

async function registerUser(){

    //Extract the inputs from the user
    let username = document.getElementById("usernameInput").value 
    let password = document.getElementById("passwordInput").value
    let email = document.getElementById("emailInput").value

    //Now, we can try to send our fetch request
    try{

        const response = await fetch("http://localhost:7777/users", {
            method: "POST",
            body:JSON.stringify({ //remember, stringify turns JS into JSON
                custUsername:username,
                custPassword:password,
                custEmail:email,
                custRole:"USER" //notice we're hardcoding Role like this
            }),
            headers:{
                "Content-Type":"application/json"
            }
        })

        if(!response.ok){
            //console.log(await response.text())
            throw new Error(await response.text())
        }

        alert("Registered " + username + " Successfully!")

    } catch(error){
        alert(error)
    }

}