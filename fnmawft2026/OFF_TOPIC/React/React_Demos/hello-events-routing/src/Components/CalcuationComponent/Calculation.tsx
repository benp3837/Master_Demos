import { useState } from "react"
import "./Calculation.css"

export const Calculation:React.FC = () => {

    //Some state variables to store the user's input and the result of the calculation
    const [SideA, setSideA] = useState<number>(0)
    const [SideB, setSideB] = useState<number>(0)
    const [result, setResult] = useState<number>(0) //probably don't NEED this one to be state

    //Function that stores user input when either input box changes
    const storeValues = (event:React.ChangeEvent<HTMLInputElement>) => {

        //If the name of the changed input is "SideA", then store Side A
        //Otherwise, store SideB
        if(event.target.name === "SideA"){
            setSideA(parseInt(event.target.value))
        } else {
            setSideB(Number(event.target.value))
        }
        //Note the 2 different ways we can explicitly cast to a number^
        //Number() is considered best practice. Number will return NaN if not a number

        //"event" is the entire onChange event object (which has the input element and its value)
        //"target" is the Input element that was changed

    }


    //Function to do the calculation and store it in the result state object
    const calculateResult = () => {

        //TODO: user input handling would be good here (check for valid numbers, or existence of both numbers)

        //We can use the Math class to calculate hypotenuse
        const result = Math.hypot(SideA, SideB) //<- These values are stored in the state objects

        //Set the result using the setResult mutator
        setResult(result)

        //Yes, this could have just been one line inside setResult() :)
        //Probably less confusing that way, as there are now 2 different variables called "result"

    }

    return(
        <div className="input-container">
            <h3>Calculation Component</h3>

            {/* Conditional Rendering! If SideA or SideB are <= 0... 
            render a message telling the user to input valid values */}
            <p>
                {SideA <= 0 || SideB <= 0 ? "Please enter 2 valid values to calculate hypotenuse" : " "}
            </p>

            <input type="number" name="SideA" onChange={storeValues}/>
            <input type="number" name="SideB" onChange={storeValues}/>

            
            <p>
                {/* If the result state value is truthy, tell the user their result */}
                {result ? "You calculated: " + result : ""}
            </p>

            <button onClick={calculateResult}>Calculate!</button>
        </div>
    )

}