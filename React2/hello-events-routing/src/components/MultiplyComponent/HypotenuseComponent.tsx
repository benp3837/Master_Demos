import React, { useState } from "react";
import { ResultComponent } from "../ResultComponent/ResultComponent";
import { SideComponent } from "../InputComponent/SideComponent";

import "./HypotenuseComponent.css";

/*This is a function component, not a class component: hence React.FC (React.FunctionComponent)
best practice to make a component take "any" as props, in case the application gets scaled up
Lastly, function components are just one big lambda/arrow function (hence () => {}) */
export const HypotenuseComponent: React.FC<any> = () => {

     //use the useState hook to let us set variables (state), mutators (like setters), and defaults
     let [userVals, setValues] = useState({first:0, second:0}) //yes we can use objects as default val!
     let [result, setResult] = useState(0) //set to zero by default
 
     /* Declaring a function that takes in an object (of any type) to calculate hypotenuse.
     This will be called every time a SideComponent changes (when a user inputs a side value).
     within this function, we'll use our setValues mutator to set side values for calculation */
     const calculateResult = (e:any) => {
         //fill out the values object using our setValues mutator, with whatever user data comes in
         //we'll take the name of the input, and give the value to the specified input (first or second)
         setValues(
             {
                 //remember we need "..." if we're referring to an object
                 ...userVals,
 
                 /* WHAT is this syntax? 
                 the value inserted will be assigned to either "first" or "second"... 
                 depending on which value the user inputs.
                 e.g. first:value OR second:value. IT'S VALUE ASSIGNMENT!!! */
                 [e.target.name]:e.target.value 
             }
         )
 
     //multiple the user's inputs, and put the result into this resultCalc variable 
     //(the square root of the sum of both sides to the second power)
     setResult(userVals.first * userVals.second)
 
 }

    return(
        <div className="input-container">
            <h3>Multiply Two Numbers:</h3>
            <SideComponent name="first" onChange={calculateResult}/>
            <SideComponent name="second" onChange={calculateResult}/>
            <ResultComponent values={userVals} result={result}/>
        </div>
    )

}