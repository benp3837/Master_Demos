//This is a TypeScript file. TS is a quirky little language that is like a java/JS hybrid
//It's a SUPERSET of javascript

//console log just like in JS
console.log("Hello Typescript");

//we should strongly type our typescript
let greeting : string = "hi";

//WOAH not like JS - can't make a string an int so easily
//greeting = 500;

//one TS-exclusive data type is the "any" datatype
//used for type flexibility.
let coolVar:any = 789000;
coolVar = "Now I'm a String!";
coolVar = 8327274867264872364873264832;
coolVar = true;

//we can make classes in TS, good for holding data (or stuff like objects that come from the server)
class Person {
    //variables
    name:string;
    motive: string;

    //constructor
    constructor(name:string, motive:string){
        this.name = name;
        this.motive = motive;
    }

    //function
    sayHi(){
        console.log("Hi I'm " + this.name)
    }

}

//instantiate a Person object
let ben:Person = new Person("Ben", "Vengeance");

console.log(ben)
ben.sayHi()

//Type Guard-------------------------------

//We'll define a "User" union type that has can be 1 of 2 types, with different roles

  interface Admin {
    role: 'admin';
    username: string;
    adminId: number;
  }
  
  interface Employee {
    role: 'employee';
    username: string;
    employeeId: number;
  }

type User = Admin | Employee;
  
//This function will check for the user's role before proceeding with whatever the user is trying to do
function isAdmin(user: User): user is Admin {
    return user.role === 'admin';
  }

//Only admins can get sales info! 
//Plus, we won't be able to compile if the admin tries to refer to an "employeeId", which only Employees have
function getSalesInfo(user: User) {

    if (isAdmin(user)) {
        //TypeScript now knows `user` is an Admin
        console.log(`${user.username} is checking sales info. Their id is: ${user.adminId}`);
        //console.log(user.employeeId) <----"Property employeeId does not exist on type Admin"
    } else {
        //If this invokes, Typescript knows "user" is an Employee
        console.log(`${user.username} was prevented from checking sales info because they aren't an admin`);
    }

}

//Let's try it - note the compilation issues if our 3rd parameter is wrong
getSalesInfo({role:"admin", username:"guy", adminId:500})
getSalesInfo({role:"employee", username:"guy", employeeId:500})
    