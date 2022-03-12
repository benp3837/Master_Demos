import React from "react";

//This creates a class based Component with Typescript. The Component takes in two {parameters}
//The parameters are props and state, which we'll mess with later
export class FirstClassComponent extends React.Component<{},{}>{

    //Every class based component must contain the render method
    render(): React.ReactNode {
        //the render method returns JSX... what's JSX again?
        return <h2>This is a class based component!</h2>
    }
    
}