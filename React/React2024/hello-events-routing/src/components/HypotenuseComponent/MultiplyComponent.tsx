import React, { useState } from 'react'

import "./MultiplyComponent.css"
import { InputComponent } from '../InputComponent/InputComponent'


export const MultiplyComponent: React.FC<any> = () => {

    //Remember, useState is a hook that lets us set and manipulate state
    //all of these will be set to zero by default
    const [firstValue, setFirst] = useState(0)
    const [secondValue, setSecond] = useState(0)
    const [result, setResult] = useState(0)

    //this function will store the first or second input value (depending on which one chenged)
    //we will take the name of the input, and assign values to state depending on that name
    const storeValues = (input:any) => {

        //input.target.name = the "name" attribute of the input box
        //input.target.value = the value inside the input box
        if(input.target.name === "first"){
            setFirst(input.target.value) //the mutator for firstValue!
        } else {
            setSecond(input.target.value) //the mutator for secondValue!
        }

    }


    //this function will find the hypotenuse given firstValue and secondValue
    const calculateHypotenuse = () => {

        //calculate the hypotenuse, then use the mutator of result to store the hypotenuse
        let hypotenuse:number = Math.sqrt(Math.pow(firstValue, 2) + Math.pow(secondValue, 2));

        setResult(hypotenuse);

    }


    //onChange is an attribute that can trigger some functionality when the element changes
    //we're setting onChange as part of props, and it will be called in the InputComponent
    return(
        <div className="input-container">
            <h3>Hypotenuse Calculator!</h3>

            <InputComponent name="first" onChange={storeValues}/>
            <InputComponent name="second" onChange={storeValues}/>

            {/* This last part could have been stored in a ResultComponent to modularize even further*/}

            <p style={{color:"red"}}>
                {firstValue && secondValue ? '' : "Please Enter Both Numbers!"} 
            </p>
            <div>
                {result ? <p> You Calculated: {result}</p> : ""}
            </div>
            <button onClick={calculateHypotenuse}>Calculate!</button>

        </div>
    )
}