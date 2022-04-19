import React from "react";

import './ResultDisplay.css'

export const ResultDisplay: React.FC<any> = (props:any) => {
    
    //remember the return() method in a Functional Component is where you write the users view
    return(
        /* if the first and second value exist (which makes this truthy), 
        populate the <p> to contain the following text
        
        otherwise, tell the user to enter both numbers if they want their value
        */
   <div className="result-container">
      <p>
        {props.values.first && props.values.second ? `Result is: ${props.result}`
        : `Enter both numbers for a value`}
      </p>
    </div>
    );
}