//the first step in any React component is to import React from "react". (You can autocomplete)
import React from "react";

//Below, we're creating a CLASS BASED COMPONENT with Typescript. The component takes two parameters
//The parameters are props and state, which we'll mess with later.
export class FirstClassComponent extends React.Component<{}, {}>{

    //creating a String variable, which we'll databind below
    //in a TS Class, we don't use let/var/const. They aren't even recognized
    words:String = "I am stored in a variable in the Class Component."

    //Every Class Based Component must contain the render() function
    //This is what the component will actually display (aka RENDER) onto the webpage
    render(){
        //the render() function must contain a return statement, where the TSX is written
        return(
            /*only block comments are allowed in the return statement*/
            <div> 
                <h3>Hello from the FirstClassComponent! This is a Class-based Component</h3>
                <p>Data bound words: {this.words}</p>
            </div>
            /* What is "this"? this.xyz just means we're calling a variable from THIS class.
               Just like how it's used in a Java constructor */
        )
    }


}