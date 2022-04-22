import React from "react";

//This is a higher order component; it takes in a component, and returns it with added functionality
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