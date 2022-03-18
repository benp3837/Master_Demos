import React from "react";

//This creates a CLASS based Component with Typescript. The Component takes in two parameters
//The parameters are props and state, which we'll mess with later
export class FirstClassComponent extends React.Component<{},{}>{

    //creating a string variable to show {databinding} below
    words:string = "I am stored in a var in the class component";

    //Every class based component must contain the render method
    //This is what the component actually displays (aka renders) onto the webpage
    render() {
        //this render method returns TSX... an HTML-like syntax that creates the view
        return ( 
            <div>
                <h2>Hello from our first class based component!</h2>
                <p>{this.words}</p>
            </div>
        )    
    }
}