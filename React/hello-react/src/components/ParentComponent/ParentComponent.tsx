import React from "react";

import { ChildComponent } from "../ChildComponent/ChildComponent";

export class ParentComponent extends React.Component<any, any>{

    //this is a TS object, exact same syntax as a JS object. It has one property called color
    state = {
        color: 'blue'
    }

    public render(): React.ReactNode {
        return(
            <div>
                <h1>Hello from the Parent Component! My favorite color is: {this.state.color}</h1>
                <ChildComponent color={this.state.color}/>
            </div>
        )
    }


}