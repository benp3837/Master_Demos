//Comments are the same as Java

//"print" statements are actually console logs (logging things to the console)
console.log("===============================(Printing/Declaring Variables)")

//JS is LOOSELY TYPED - we don't need to declare datatypes
//We can also reassign variable types as needed

a = 500 //(single "number" type)
a = true
a = null
a = "I'm a string"

//By default, JS uses "var" to declare variables, but you should use let or const
//WHY? See the functions/scopes demo - it's due to something HOISTING

var b = "I'm a var by default! No need to say var"

let b2 = "I am a let. More modern way to declare variables. We typically use these"

const b3 = "I am a const. Like 'final' in Java, my value can't change"

//JS Arrays - can hold different datatypes and grow/shrink in size
let arr = [10, "A String", false, undefined, null, {name:"Billy", age:5}]

arr.push("Something new")

console.log(arr)


//Template Literals allow us to make multi-line console logs using `backticks`
console.log(` I
    Am 
    On
    Multiple
    Lines
    `)


//If you ever run into mathematical issues - you might get the NaN datatype
console.log("string"/0)


console.log("=========================(Testing Type Coercion)")

//Lets see what JS decides to coerce these datatypes into

console.log("5" + 5) //55: JS decides String + number = String

console.log("5" * 5) //25: JS decides String * number = number

//Any mathematical operation with a String that ISN'T + will make 2 number
//Strings with + CAN result in concatenation

console.log(5 + 5 + "5") //Number 10 + String 5 = 105

//It's all math UNTIL a String is involved

console.log("5" + 5 + 5)

console.log("===========================(Truthy/Falsy values")

//Testing out some Falsy Values (values that evaluate to the boolean false)

if(0){
    console.log("Will I print?")
} else {
    console.log("0 is falsy - useful if we're checking the length of an array")
}

if(""){
    console.log("Will I PRINT??")
} else {
    console.log("Empty string is falsy - useful check for if the user passed nothing in")
}

//Any of the 6 non-falsy values evaluate to true
if(1){
    console.log("Nonzeros are truthy")
}

if(2){
    console.log("Nonzeros are truthy")
}

if(1 == true){
    console.log("1 is equal to true")
}

if(2 == true){
    console.log("2 is equal to true") //DOESN'T PRINT!
}

//While any non-zero is truthy, 
//the boolean true and the number one are the ones ones that are EQUAL

