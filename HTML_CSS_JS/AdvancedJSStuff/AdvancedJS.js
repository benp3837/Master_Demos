//importing our exportable function from Utils.js!
import { learnSkill } from "./Utils.js";

//Gonna use this person object in our script
const person = {
    name:"Billy",
    age:"5"
}

//Destructuring our person object so we can get individual variables out of it
const {name, age} = person;

console.log(name + " is " + age + " years old")

//Using our imported function from Utils.js
learnSkill(name, "welding")

//---------------------------------------(Spread/Rest Operators)

//The spread operator is nice for passing the values of an Array into some other construct
const numbers = [1, 2, 3]
const evenMoreNumbers = [...numbers, 4, 5, 6] //[1, 2, 3, 4, 5, 6]

console.log(Math.max(...evenMoreNumbers)) //same as Math.max(1, 2, 3, 4, 5, 6)

//The rest operator is nice when you want to gather a variable amount of values
function sum(...values){

    let result = 0

    for(let i of values){
        result += i
    }

    console.log("Sum: " + result)
}

sum(...numbers) //another example rest operator ;)
sum(...evenMoreNumbers)


/*Our person Billy up there is an "object literal". 
But the curriculum has a topic for "Advanced Object Literals"... what's that?
It's just a newer, shorter way to define object literals

Here's one example of their utility: using existing variables as keys/values 
*/

const foodName = "Pizza"
const topping = "Pepperoni"

const food = {
    foodName,
    topping
}

console.log(food)

//other advanced object literal shorthands to look into: methods and computed properties