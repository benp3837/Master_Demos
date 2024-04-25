import React from 'react'

import "./Pokemon.css"
import { PokemonInterface } from '../../interfaces/PokemonInterface'

export const Pokemon: React.FC<any> = (props:any) => {



    //If there is no value for pokePic (if it's falsy) then we render an empty <p> tag. Otherwise, we render the pokemon image 
    //This is sometimes referred to as "conditional rendering"
    return(
        <div className="pokemon-container">

            <div>
                {props.pokemon.image ? <img className="pokemon-pic" src={props.pokemon.image} alt="POKEPIC" /> : <p></p> }
            </div>

            <h3>{props.pokemon.name}</h3>

        </div>
    )
}