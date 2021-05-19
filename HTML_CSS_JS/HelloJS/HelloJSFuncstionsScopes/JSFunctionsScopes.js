console.log("===============================================(Functions)");

//This is a basic named JS function. 
//Note because of hoisting we can call the function before we declare it.

helloWorld(); 

function helloWorld() {
  console.log("HELLO WORLD!");
}

//Here's an Anonymous function, it hasn't been named but it's been assigned to a variable
var anon = function () {
  console.log("I'm an anonymous function");
}
anon(); //using the anonymous function

//Arrow functions are pretty much like Java lambdas (agruments => expression)
var arrow = () => {console.log("I'm in an arrow function!")}
arrow();

//Callback functions
function func1(x){
    console.log("Inside func1");
    console.log("x = " + x);
}

function func2(y, cb){
    console.log("Inside func2");
    cb(y); //so cb is intended to be a function, and take y as an argument
}

func2(9, func1); //so let's call func2, and pass in func1 as the "cb" argument

//let's pass in an arrow function as the "cb" argument instead
func2(5, (x)=>{console.log("You gave the arrow function: " + x)});

//in these two cases, func1 and the arrow function are the callback functions func2 is invoking!


//Finally lets look at closures
let HelloName = function (name){
    return function (){
      console.log("Hello "+name);
    }
}
  
let nameTim = HelloName("Tim");
  
nameTim(); 
  
HelloName = HelloName("Luke"); 
//now we can never change the name value from Luke
  
HelloName(); 
  
let nameJohn = HelloName("John"); //this just causes helloName to run, with an argument it ignores.
  
//nameJohn(); //error: nameJohn is not a function! it's not recognized by the compiler


console.log("================================(Global Scope)");

console.log(a); //prints undefined because it was hoisted

//this global scoped
var a = 5;

console.log(a); //NOW it prints 5


//console.log(b); //error in the console - b is a "let" so it's not hosted

let b = "b";

console.log(b);


console.log("===================================(Local Scope)");

console.log(c); //undefined

if(true){
    var c = "I'm a var in a block";
    console.log(c);
}

console.log(c); //"I'm a var in a block"

if(true){
    let d = "I'm a let in a block";
    console.log(d); //"I'm a let in a block"
}

//console.log(d); //reference error! d is out of scope so it doesn't exist here.

function testScope() {
    //var e is hoisted only to the top of the function, not to the global scope
    console.log(e); //undefined 
    var e = "I'm in a function!"
    console.log(e);
}

testScope();
//console.log(e); e is out of scope so this causes a reference error. 