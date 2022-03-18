import React from "react";

import { ChildComponent } from "../ChildComponent/ChildComponent";

//note the end of this signature... this class may take ANY props and state
export class ParentComponent extends React.Component<any, any>{

    //this is a TS state object, which is another way to initialize a class component's state
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