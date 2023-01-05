//this component will simply render a Pokemon and get nested in the Home component
import React from "react"

import "./Pokemon.css"

export const Pokemon: React.FC<any> = (props:any) => {

    return(
        <div className="pokemon-container">
            <img className="poke-pic" src={props.sprite} alt={props.name}/>
            <h3>{props.name}</h3>
        </div>
    )

}