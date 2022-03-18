import React from "react";

export class ChildComponent extends React.Component<any, any>{

    //this is a constructor, which is one way to initialize a class component's state
    constructor(props:any){
        super(props);
        //remember, state is how we store data in a component
        this.state = {
            favColor: props.color
        }
    }

    public render(): React.ReactNode {
        return(
            <h3 style={{color: this.state.favColor}}>Child Component is {this.state.favColor}</h3>
        )
    }

}
