import React from "react";

//This is our actual higher order component; 
//it will get taken in by the Loading component, and returned it with added functionality
export const HOCList:React.FC<any> = (props:any) => {

    const {list} = props;

    if(!list) return null;

    return(
        <ul>
            {list.map((item:any) => {
                return <li key={item.postId}>{item.content}</li>
            })}
        </ul>
        
    );
}