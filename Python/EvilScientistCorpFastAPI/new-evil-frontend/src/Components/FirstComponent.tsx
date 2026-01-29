import { useState } from "react";

/* Here's a React FUNCTION COMPONENT. It's a view AND its logic, all wrapped into a function.
Our React Components will all be Arrow Functions 
In this component, we're providing no values, hence the empty ()

"export" - We need this so our Component can be imported around the app
"const" - The Component can't be reassigned, changed, etc
"React.FC" - We're saying this is a React (F)unctional (C)omponent
    -Basically we're defining what datatype this function returns
*/
export const FirstComponent:React.FC = () => {

    //Using a React Hook called useState to manage this variable. We remember State right? 
    //The useState hook lets us manage the State of a component (variables and their values)
    const [count, setCount] = useState<number>(0);

    //We can define variables and logic in the space above the returned view
    const message:string = "I am a value stored in FirstComponent, and rendered in the view"

    //Here's a function that will get invoked if the button below is clicked
    const showMessage = () => {
        alert(message)
        setCount(count + 1)
    }

    //Notice the data binding of the message variable in the view
    return(
        <div style={{ border: "2px solid black", padding: "10px", borderRadius: "5px" }}>
            <h4>Hi from FirstComponent! Click this button, I dare you</h4>
            <button onClick={showMessage}>Click me! Click meeeeee</button>
            <p>Click Count: {count}</p>
        </div>
    )

}