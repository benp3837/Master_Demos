//this component will simply render a Pokemon and get nested in the Home component
import React from "react"

import "./Pokemon.css"

export const Pokemon: React.FC<any> = (props) => {

    return(
        <div className="pokemon-container">
            <img className="poke-pic" src={props.poke.sprite} alt="pokemon"/>
            <h3>{props.poke.name}</h3>
        </div>
    )

}