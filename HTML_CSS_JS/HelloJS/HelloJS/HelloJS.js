console.log("=============================(Printing and Declaring stuff)")

//This will print to the console, not the actual webpage
console.log("Hey JavaScript, please be nice to me") //you don't need a semicolon, but I like them

//JavaScript is loosely typed so I can change the type of value a variable holds
var a = 100;
console.log(a) 
a = true;
a = null;
a = "Now I'm a String!";
console.log(a);

var b;
console.log("hello" + b); //prints undefined

//JS will add "var" implicitly since it's the first time the variable appears
c = "I wasn't declared. JS will do the work for me though"
console.log(typeof c) //string

console.log("=============================(Truthy/Falsey)")

//Let's write a function that compares two vars
function test(var1, var2){
    console.log(var1 + " compared to " + var2);
    console.log(var1 == var2);
}
  
  test("3", 3); //true
  test(0,false); //true
  test(1,true); //true
  test(2,true); //false - see below
  test(2,false); //false
  
  //while 2 is truthy, the boolean true is 
  //evaluated as the number 1 and false is evaluated as 0 so when 
  //compared the result is always false

    //some if statements to drive the point home
  if(2){
    console.log("2 is truthy") //*
  }else{
    console.log("2 is falsey")
  }
  
  if(0){
    console.log("0 is truthy")
  }else{
    console.log("0 is falsey") //*
  }
 
//some more falsey tests
test('', false); //true
test(null, undefined); //true

//when you compare a boolean to a non-boolean, it turns into a number
test("string", true); //compares "string" to 1; //false
test('true', true); //compares "true"=="1"; //false
test("1", true); //true
test("false", false); //false
test("0", false); //true

