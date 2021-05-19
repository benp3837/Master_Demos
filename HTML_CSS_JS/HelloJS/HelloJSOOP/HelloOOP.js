console.log("===================(A class called Baby)");
//defining a class with a class declaration (using class keyword)
//also added a constructor
class Baby {
    constructor(name, stinky){
        this.name = name;
        this.stinky = stinky;
    }

    cry(){
        alert(this.name + " goes *WAAAAAAAHHHHHHH* from a class declaration");
    }
}

console.log(Baby); //print the contents of the Baby Class to the console
let baby1 = new Baby("Ben", false); //create a new Baby object using the constructor
baby1.cry(); //make Ben cry
//-----------------------------------------------------------------------------


console.log("=============(A variable called baby assigned to an object)")
//defining a class with a class expression (assigning an object to a variable)
//notice how baby and Baby can coexist! Java treats them as two different things
let baby = {
        name:"baby",
        stinky:true,  
    cry(){
        alert(this.name + " goes *WAAAAAAAAH* from a class expression");
    }
}

console.log(baby); //print the contents of the baby variable to the console

baby.cry(); //invoke the cry method
//------------------------------------------------

console.log("=========(A variable called roboBaby that inherits from baby)")
//using Inheritance in JS!!!

//here's a new object using a class expression
//Use the __proto__ property to declare baby as a parent class
let roboBaby = {
    isRobotic:true,
    __proto__:baby
}; 

console.log(roboBaby.name) //we can access the "name" property of the baby Class 
roboBaby.name = "BabyBot"; //we can also change "name" for roboBaby
console.log(roboBaby.name) //name changed!

roboBaby.cry(); //we can invoke the cry() method of the baby Class too

console.log(roboBaby); //notice stinky and cry() don't print, but they're still there