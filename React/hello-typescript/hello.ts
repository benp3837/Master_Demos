//This is a typescript file. it's a quirky lil language that is like a java/javascript hybrid
//It's actually considered a SUPERSET of javascript

//console logs just like JS
console.log("hi");

//not necessary, but recommended to strongly type your variables (give data types on declaration)
let greeting:string = "hey";

//WOAH!! not like JS - can't make a string an int.
//greeting = 1;

//one TS-exclusive versatile data type is the "any" datatype
let coolVariable:any = 420;
coolVariable = "Now I'm a String!! Heyo"

class Person {
    //fields
    name:String;
    motive:String;

    //constructor
    constructor(name:String, motive:String) {
        this.name = name;
        this.motive = motive;
    }
}

//instantiate a Person object
let Ben:Person = new Person("Ben", "vengeance");


//DOM selection, event listener, button click, change some HTML
document.getElementById("butt").addEventListener("click", messageFunc);

//function to change the function in our HTML template
function messageFunc(){
    
    document.getElementById("message").innerHTML = Ben.name + " is out for " + Ben.motive;

}

//typescript is written! But we need to transpile it

//install the tcg transpiler:
//npm install -g typescript

//transpile your TS with:
//tsc hello.ts