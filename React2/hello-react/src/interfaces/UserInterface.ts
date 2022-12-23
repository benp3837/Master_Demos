//Hopefully you all remember how Java Interfaces work :)
//TS Interfaces are pretty much the same, but we usually store just objects, no functions

//We will make a UserComponent that inherits from this interface
export interface UserInterface {
    firstName: string,
    lastName: string,
    username: string,
    email: string
}