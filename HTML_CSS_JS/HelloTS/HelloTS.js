//This is a TypeScript file. TS is a quirky little language that is like a java/JS hybrid
//It's a SUPERSET of javascript
//console log just like in JS
console.log("Hello Typescript");
//we should strongly type our typescript
var greeting = "hi";
//WOAH not like JS - can't make a string an int so easily
//greeting = 500;
//one TS-exclusive data type is the "any" datatype
//used for type flexibility.
var coolVar = 789000;
coolVar = "Now I'm a String!";
coolVar = 8327274867264872364873264832;
coolVar = true;
//we can make classes in TS, good for holding data (or stuff like objects that come from the server)
var Person = /** @class */ (function () {
    //constructor
    function Person(name, motive) {
        this.name = name;
        this.motive = motive;
    }
    //function
    Person.prototype.sayHi = function () {
        console.log("Hi I'm " + this.name);
    };
    return Person;
}());
//instantiate a Person object
var ben = new Person("Ben", "Vengeance");
console.log(ben);
ben.sayHi();
//This function will check for the user's role before proceeding with whatever the user is trying to do
function isAdmin(user) {
    return user.role === 'admin';
}
//Only admins can get sales info! 
//Plus, we won't be able to compile if the admin tries to refer to an "employeeId", which only Employees have
function getSalesInfo(user) {
    if (isAdmin(user)) {
        //TypeScript now knows `user` is an Admin
        console.log("".concat(user.username, " is checking sales info. Their id is: ").concat(user.adminId));
        //console.log(user.employeeId) <----"Property employeeId does not exist on type Admin"
    }
    else {
        //If this invokes, Typescript knows "user" is an Employee
        console.log("".concat(user.username, " was prevented from checking sales info because they aren't an admin"));
    }
}
//Let's try it - note the compilation issues if our 3rd parameter is wrong
getSalesInfo({ role: "admin", username: "guy", adminId: 500 });
getSalesInfo({ role: "employee", username: "guy", employeeId: 500 });
