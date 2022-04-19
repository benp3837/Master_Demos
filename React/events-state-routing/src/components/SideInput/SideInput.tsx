import React from "react";

//remember to note that Errors will be thrown until you write all the preliminary stuff
//hey uh does props:any let you just automatically pull values from any other component?
export const SideInput: React.FC<any> = (props:any) => {

    //return() to render the component's view in Functional Components
    return(
        <div>
            Enter {props.name} side value:
            <input name={props.name} type="number" onChange={props.onChange}/>
        </div>
    )
}