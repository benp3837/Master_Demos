console.log("(Printing/Declaring Variables)===============================================")

console.log("Hello Javascript, please be nice");

//Js is loosely typed, so I can easily change the data type of a variable
var a = 100; //number

a = true;
console.log(a);

a = null;
console.log(a);

a = "now I'm a string";
console.log(a);

//trying to get NaN (not a number)
console.log("some string"/10);

//JS will add the "var" keyword implicitly when declaring a variable
b = "I am a var";

let b2 = "I am a let";

const b3 = "I am a const, I am immutable";

console.log("(Testing Type Coercion)===============================================")

let tc1 = "5" * 5;
console.log("String times number is: " + typeof tc1);
console.log(tc1);

let tc2 = "5" * "5";
console.log("String times number is: " + typeof tc2);
console.log(tc2);

let tc3 = "5" + 5;
console.log("String plus number is: " + typeof tc3);
console.log(tc3);

let tc4 = 5 + "5";
console.log("number plus string is: " + typeof tc4);
console.log(tc4);

//order doesn't matter if it's only two values - then only the operator matters

//let's explore type coercion with multiple values
let tc5 = 5 + 5 + "5"; 
console.log("number plus number plus string is: " + typeof tc5);
console.log(tc5); //5 + 5 = 10; 10 + "5" = 105;

let tc6 = "5" + 5 + 5; 
console.log("string plus number plus number is: " + typeof tc6);
console.log(tc6); //"5" + 5 = 55; "55" + 5 = 555;

let tc7 = 5 + "5" * 5; 
console.log("number plus string times number is: " + typeof tc7);
console.log(tc7); //PEMDAS!!! "5" * 5 = 25; 25 + 5 = 30;

/*"It's all math UNTIL a String gets put in the mix. Then the operator matters."
typically + with strings create strings, other math ops tend to create numbers */

console.log("(Truthy/Falsy)===============================================")

//I want to write a function that compares two variables
function testTrueFalse(var1, var2){
    console.log(var1 + " compared to " + var2);
    console.log(var1 == var2);
}

testTrueFalse(0, false); //true
testTrueFalse(1, true); //true
testTrueFalse(2, false); //false
testTrueFalse(2, true); //FALSE.... what??? see below

//while 2 IS truthy... the boolean true evaluates to the number 1, while boolean false evaluates to 0.
//so comparing any number besides 1 to true will return false

//a if statement to demonstrate this
if(2){
    console.log("any number besides 0 is truthy");
}