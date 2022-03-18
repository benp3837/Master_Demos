import React, {useState} from "react";

export const HypotenuseComponent: React.FC<any> = () => {

    //use the useState hook to set variables with manipulation functions and default values
    let [values, setValues] = useState({first:0, second:0}) //yes we can use objects!
    let [result, setResult] = useState(0)
    
    //declaring a function that takes in an object to calculate hypotenuse
    const calculateResult = (e:any) => {
        
        setValues(
            {
                //varargs! So we can take any number of values
                ...values,
                //I HAVE NO IDEA WHAT'S HAPPENING HERE
                [e.target.name]:e.target.value
            }
        );

        //the result of the hypotenuse calculation is the sum of each value to the second power
        let result = Math.sqrt(
            Math.pow(values.first, 2) + Math.pow(values.second, 2)
        );

        //round the result so it's a prettier number
        result = Math.round(result * 100)/100;

        //finally, assign the result of our calculations to the result variable
        setResult(result);
    }

    return(
        <div>
            <h3>Calculator</h3>
            <div>
                Enter your first side value:
                <input name="first" type="number" onChange={calculateResult}/>
            </div>
            <div>
                Enter your second side value:
                <input name="second" type="number" onChange={calculateResult}/>
            </div>
            <p>
                {values.first && values.second ? `Result is: ${result}`
                : `Enter both numbers above for a value`}
            </p>
        </div>
    );

}