//This is a TypeScript file - TS is a quirky little language that's like a JS/Java hybrid
//It's a SUPERSET of JavaScript - so all valid JS is valid TS. 

//Lots of similar syntax to JS - look at the console.log
console.log("Hello Typescript - we'll be using you in Angular apps")

//We should strongly type our TypeScript
let greeting:string = "Hello TypeScript"

//NOT LIKE JS HERE! We care more about typing in TYPEscript. Strict/Strong typing
//greeting = 500

//one TS-exclusive datatype is the "any" datatype
//good for type flexiblity (it can be "any" datatype) 
    //but not great for type scrictness, which is a major key to TS
let flexibleVar:any = 135253
flexibleVar = "A String now"
flexibleVar = true
flexibleVar = null

//Arrays in TS are NOT fixed in size, but can only keep one datatype 
let names:string[] = ["Charlie", "Tony", "Paul"]
let anything:any[] = ["Whatever", 35235, true]

//We can make Classes in TS, good for holding and modeling data
class Person {
    //variables
    name:string;
    motive:string;

    //we can have methods too (a method is just a function defined in a class)
    stateMotive(){
        console.log(this.name + " is driven by " + this.motive)
    }

    //constructor - Every class needs a constructor for us to initialize an object
    constructor(name:string, motive:string){
        this.name = name
        this.motive = motive
    }
}

//Instantiate some Persons
let people:Person[] = []

for(let name of names){
    people.push(new Person(name, "Education"))
}

//Call the motive method of each person
for(let person of people){
    person.stateMotive()
}

