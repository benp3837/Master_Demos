import React from "react";

export class ChildComponent extends React.Component<any, any>{

    //this is a constructor, which we'll use to....
    constructor(props:any){
        super(props);
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
