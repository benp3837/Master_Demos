import React from "react"

//This component will take in user inputs for triangle sides (so we can calculate hypotenuse)
//it takes in any kind of data for props, and we'll call the props object props for clarity.
export const SideComponent: React.FC<any> = (props:any) => {

    /* we render a prompt telling the user to enter a triangle side 
    the user inputs a value, which gets associated with one or the other side in the Hypotenuse calculation.
    onChange (when the user changes the value in the input), run onChange from Hypotenuse Comp.*/
    return(
        <div>
            <p>Enter {props.name} value: </p> 
            <input name={props.name} type="number" onChange={props.onChange}/>
        </div>
    )

} 