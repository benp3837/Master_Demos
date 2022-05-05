import React, {useState} from "react";
import {ResultDisplay} from "../ResultDisplay/ResultDisplay";
import { SideInput } from "../SideInput/SideInput";

import './HypotenuseComponent.css'

export const HypotenuseComponent: React.FC<any> = () => {

    //use the useState hook to set variables with manipulation functions and default values
    let [values, setValues] = useState({first:0, second:0}) //yes we can use objects!
    let [result, setResult] = useState(0)
    
    //declaring a function that takes in an object to calculate hypotenuse
    const calculateResult = (e:any) => {
        
        setValues(
            {
                //need ... if you're referring to an object
                ...values,
                //I HAVE NO IDEA WHAT'S HAPPENING HERE
                [e.target.name]:e.target.value
            }
        );

        

        //the result of the hypotenuse calculation is the sum of both values to the second power
        let resultCalc = Math.sqrt(
            Math.pow(values.first, 2) + Math.pow(values.second, 2)
        );

        //round the result so it's a prettier number
        resultCalc = Math.round(resultCalc * 100)/100;

        //finally, assign the result of our calculations to the result variable
        setResult(resultCalc);
    }

    return(
        /* This HypotenuseComponent will be displayed on the main page
            and ask the user to enter the first and second side values
            then calculate the Result every time the component changes.

            Then, ResultComponent is called, using the two inserted values and the result
        */
        <div className="input-container">
            <h3>Calculator</h3>
            <SideInput name="first" onChange={calculateResult}/>
            <SideInput name="second" onChange={calculateResult}/>
            <ResultDisplay values={values} result={result} ></ResultDisplay>
        </div>
    );

    

}