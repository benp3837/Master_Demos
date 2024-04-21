//First we'll make a basic named function
//because of hoisting, we can call this method before we actually declare it
helloWorld();

function helloWorld(){
    console.log("hola mundo");
}

/* Here's an anonymous function, it hasn't been named, but it's assigned a variable 
So basically, it's a function stored in a variable */
var anon = function(){
    console.log("I'm in an anonymous function!!");
}

anon(); //we call the variable to invoke the function

/* Arrow functions are basically like Lambdas in Java 
takes in some argument(s), and performs some logic */
let test = (var1, var2) => {
    console.log(var1 + " compared to " + var2);
    console.log(var1 == var2);
};

//thanks Luan... now we can call this function to compare the values (NOT TYPES) of two variables
test(1, true);
test(" ", false);


//Callback functions - functions that take in another function as a parameter
function f1(x){
    console.log("Inside function A");
    console.log("The value passed in from function B is: " + x)
    console.log("End of function A")
}

function f2(y, callBack){
    console.log("Inside function B");
    callBack(y); //so "callBack" is intended to be a function
    //which takes in "y" as its argument
    console.log("End of function B")
}

//using the callback function
f2(100, f1);


//Closures - an older way of achieving encapsulation in JS 
let helloName = function (name) {
    return function(){
        console.log("Hello, " + name);
    }
}

//the nested function can access the "name" argument, but can't change it

//assign the function call to a variable, and give it an argument for name
let nameBen = helloName("Ben");

nameBen(); 

//BUT once we assign the helloName variable, it can't ever change
helloName = helloName("Jamie");

helloName();

//attempting to change the name argument
let newName = helloName("Eggward");

helloName(); //hello Jamie still prints, despite us sending in a new value for name

console.log("(Global Scopes)=========================================")

//anything that is globally scoped is visible throughout the entire script.

console.log(a); //is this legal? yes, it's undefined though

//another example of hoisting!! vars and functions all get hoisted up to the top of their scope

var a = 5; 

console.log(a); //so now, after it's been given a value, it's no longer undefined

//let's try this with a let

//console.log(b); //is this legal? NO!! let and const are NOT hoisted. only var and functions.

let b = 10;

console.log(b); //this, however, is legal 

console.log("(Local Scopes)==========================================")

//block scope---------

if(true){
    var c = "I'm a var in a block. Block Scoped!"
    console.log(c);
    let d = "I'm a let in a block. Block Scoped!"
    console.log(d)
}

console.log(c); //This variable is visible outside of its block, since it's a VAR
//console.log(d); //This variable is NOT visible outside of its block, since it's a LET


//functional scope----------

function scopeTest(){
    console.log(e); //undefined, but not an error since its a var
    var e = "I'm a var in a function!"
    console.log(e); //now we can see the value
}

//console.log(e); we get an error here, despite e being a var. vars are scopelocked within functions

scopeTest();

/*
    The main difference between block/functional scope is...
    -vars are NOT visible outside the function they were declared in
    -BUT they are visible outside of any non-function blocks
*/