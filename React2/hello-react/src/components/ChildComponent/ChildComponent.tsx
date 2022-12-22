import React from "react";

/* 
Notice "props" is of any type here - we're expecting a state object from the parent component
"state" will also be any type, so that the Child can create its own state to potentially send around
*/

//ParentComponent sends state of any type. ChildComponent accepts props of any type. see the connection?
//The state in the parent component will always be the props in a child component
export class ChildComponent extends React.Component<any, any>{

/* 
    We can use constructors to initialize a class component and its state. Like Java consctructors/fields
    Remember, "props" is the variable coming in the left parameter of this class declaration.
    the constructor takes in that "props" object, which contains the data we'll use
*/
    constructor(props:any){
        super(props); //a call to the parent constructor (which is a default no-args)

        //initializing ChildComponent's state, using the props it got from ParentComponent's state
        this.state = {
            color:props.color,
            animal:props.animal
        }
    }

    //lets render some elements in the ChildComponent, using the props it got from the Parent
    render(){
        return(
            <div>
                <h3>Hello from the Child Component</h3>
                <h3 style={{color: this.state.color}}>My parent's favorite color is: {this.state.color}</h3>
                <h3>My parent's favorite animal is: {this.state.animal}</h3>
            </div>
        )
    }

}