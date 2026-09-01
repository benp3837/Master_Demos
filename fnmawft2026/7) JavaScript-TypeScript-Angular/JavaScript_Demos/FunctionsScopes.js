//We can call functions before they're defined due to something called HOISTING
helloWorld()

//Here's a basic "named" function
function helloWorld(){
    console.log("añong world")
}

//anon(5) <- ONLY NAMED FUNCTIONS get hoisted!!

//An anonymous function has no name. It's saved in a variable instead
anon = function(x){
    console.log("Your number is: " + x)
}

anon(5)


//Arrow functions are like Java lambdas - they take in a value and execute some logic
arrowFunction = (var1, var2) => {

    //Testing out == and ===
    console.log("--")

    //typeof returns the type of the data
    console.log("Does " + typeof var1 + " " + var1 + " equal " + typeof var2 + " " + var2)

    console.log("== " + (var1 == var2))
    console.log("=== " + (var1 === var2))

    /* WHAT'S GOING ON :( 
    
    == compares values, that's it.
    === compares values AND datatype. Good for type safety.

    Imagine an HTTP response comes back from the server:

    if(response.status === 200){
        *Do something good
    } else {
        *Error message
    }
    */
}

arrowFunction(5, "5")


//Callback Functions - a function that gets passed as a parameter to another function
function f1(){
    console.log("Hello from function 1")
}

function f2(someFunction){
    console.log("Hello from function 2")
    someFunction()
}

//Let's call f2 and pass in some callback functions
f2(f1)
//f2("Hello") <- TypeError, not a function


console.log("==================(Global Scope)")

//Anything that's Globally Scopes is visible anywhere in the application
console.log(a) //"undefined", not an error, the value just hasn't been defined

//vars are GLOBALLY SCOPED (they're HOISTED to the top of the scope)
var a = 5

console.log(a) //this of course prints 5

//Let's try the same thing with a let-------------
//console.log(b) <- ReferenceError: cannot access b before initalization

let b = 5 

console.log(b) //this works of course


//let is a bit more restrictive scope wise - BUT this is a good thing IMO -
    //we don't really want/need to access vars before definition
    //So instead of getting undefined, it's actually better to get an error
    //MORE PREDICTABLE CODE! Predictability is developer friendly.

//vars are globally scoped and hoisted. lets and consts are NOT (good.)
//standard functions are globally scoped and hoisted too, I like that - they actually work

console.log("=====================(Local Scope)")

//block scope--/

//any variable inside a non-function block is BLOCK SCOPED
if(true){
    var c = "I'm a var in a block"
    let d = "I'm a let in a block"
}

console.log(c) //vars are globally scoped no matter what. 
//They're visibile outside of the blockt they're defined in. I hate this! It's confusing

//console.log(d) <- it fails with a let, which is better. It's out of scope


//function scope--/

//any variable in a function is FUNCTION scoped
function scopeTester(){
    var e = "I'm a var in a function"
}

console.log(e) //this one actually DOESN'T work
//Why are you so weird var? The rulesets are inconsistent and I don't like that

/* The main difference between block and function scope 

   -vars are not visible outside of the function they're defined in
   -BUT... vars ARE visible outside of any non-function block they're defined it

   -lets and consts are only visible inside their block, which I like

   Since we only really use let and const these days, we don't worry about weird var behavior

   Also, functions are globally scoped and hoisted, but I actually like that for functions
   It's common to see a script have all it's function defined on the bottom of the script - clean!

*/