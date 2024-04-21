import React from "react"

export const ResultComponent: React.FC<any> = (props:any) => {

    //If there isn't a value for both the first and second, give the user a prompt to enter values
    //If there is no value for result, tell the user to click the button and trigger calculation
    return(
        <div className="result-container">
            <p style={{color: "red"}}>{props.values.first && props.values.second ? '' 
            : "Please enter both numbers"}</p>

            <div>
                {props.result ? <p> You calculated: {props.result}</p>
                : "Click calculate to find the product:"}
            </div>
        </div>
    )

}