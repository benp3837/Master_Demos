import React from "react";
import { ChildComponent } from "../ChildComponent/ChildComponent";

/*
Again, every Class component has two parameters, <props, and state>
by leaving the state parameter as "any", we can define whatever object we want to store in the state
and we'll leave the props parameter empty, since we aren't sending any data to this component
*/
export class ParentComponent extends React.Component<{}, any> {

    //creating a state object to store data
    state = {
        color: "blue",
        animal: "dog"
    }

    //we will nest a child component in this parent component to demonstrate props/state
    //specifically, we are going to send the state data to the child's props.
    render() {
        return(
            <div>
                <h1>Hello from the Parent Component! My favorite color is: {this.state.color} </h1>
                <ChildComponent color={this.state.color} animal={this.state.animal}></ChildComponent>
            </div>
        )
        //Notice that we send the state data as ATTRIBUTES in the ChildComponent. 
        //These will become the Child's props.
    }

}
