//You can think of the models folder in angular like the models package in Java
//We fill it with Classes that we intend to make Objects from
export class Pokemon {

    //this constructor will initialize the Pokemon's variables when we create one
    constructor(public name:string, 
      public types:object[], 
      public sprites:object) { }
  }