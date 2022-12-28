import React, { useState } from "react";
import { ResultComponent } from "../ResultComponent/ResultComponent";
import { SideComponent } from "../SideComponent/SideComponent";

import "./HypotenuseComponent.css";

/*This is a function component, not a class component: hence React.FC (React.FunctionComponent)
best practice to make a component take "any" as props, in case the application gets scaled up
Lastly, function components are just one big lambda/arrow function (hence () => {}) */
export const HypotenuseComponent: React.FC<any> = () => {

     //use the useState hook to let us set variables (state), mutators (like setters), and defaults
     let [sideVals, setValues] = useState({firstSide:0, secondSide:0}) //yes we can use objects as default val!
     let [result, setResult] = useState(0)//set to zero by default
 
     /* Declaring a function that takes in an object (of any type) to calculate hypotenuse.
     This will be called every time a SideComponent changes (when a user inputs a side value).
     within this function, we'll use our setValues mutator to set side values for calculation */
     const calculateResult = (e:any) => {
         //fill out the values object with our setValues mutator. with whatever user data comes in
         //we'll take the name of the side, and give the value to the specified side
         setValues(
             {
                 //remember we need "..." if we're referring to an object
                 ...sideVals,
 
                 /* WHAT is this syntax? 
                 the value inserted will be assigned to either "first" or "second"... 
                 depending on which side the user gave a value to.
                 e.g. first:value OR second:value. IT'S VALUE ASSIGNMENT!!! */
                 [e.target.name]:e.target.value 
             }
         )
 
     //calculate the hypotenuse, and put the result into this resultCalc variable 
     //(the square root of the sum of both sides to the second power)
     let resultCalc = Math.sqrt(
         Math.pow(sideVals.firstSide, 2) + Math.pow(sideVals.secondSide, 2)
     );
 
     //round resultCalc so it's a prettier number
     resultCalc = Math.round(resultCalc * 100)/100 
 
     //finally, assign this resultCalc variable to our result variable (useState)
     setResult(resultCalc);
 }

    return(
        <div className="input-container">
            <h3>Hypotenuse Component Does Not Work As Intended! How Silly</h3>
            <SideComponent name="firstSide" onChange={calculateResult}/>
            <SideComponent name="secondSide" onChange={calculateResult}/>
            <ResultComponent values={sideVals} result={result}/>
        </div>
    )

}