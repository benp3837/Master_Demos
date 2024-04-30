import { useEffect, useState } from "react"
import { PokemonInterface } from "../../interfaces/PokemonInterface"
import { Pokemon } from "../Pokemon/Pokemon"
import "./Collection.css"
import axios from "axios"

export const Collection: React.FC<any> = () => {

    //we need a useState hook to store incoming Pokemon info, to send it to the PokemonComponent
    //setting an object in useState can be cleaner, but can complicate mutations... see below 
    const [pokemon, setPokemon] = useState<PokemonInterface[]>([])

    //useEffect will call getAllPokemon when it renders
    useEffect(() => {

        getAllPokemon() 
        
    }, []) // this functionality triggers on page load and state change


    const getAllPokemon = async () => {
        //send a GET to get all pokemon
        const response = await axios.get("http://localhost:8080/pokemon", {withCredentials:true})

        //populate the pokemon state object, giving us an Array of the user's pokemon
        setPokemon(response.data)

    }

    return(
        
        <div className="collection-container">

            {/* For every pokemon in the array (called "p"), render a Pokemon Component with its data*/}
            {pokemon.map((p, index) => (
                <Pokemon key={index} pokemon={p}></Pokemon>
            ))}

        </div>
    )

}