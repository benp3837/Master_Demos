import { useEffect, useState } from "react"
import { PokemonInterface } from "../../interfaces/PokemonInterface"
import { Pokemon } from "../Pokemon/Pokemon"
import "./Collection.css"
import axios from "axios"

export const Collection: React.FC<any> = () => {

    //we'll store state that consists of an Array of PokemonInterface objects
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

        console.log(response.data)

        console.log("pokemon state: " + pokemon)

    }

    const deletePokemon = async (pokeId:number|undefined) => {
        //delete whatever pokemon the user chooses (determined by the index of the pokemon chosen)
        
        const response = axios.delete("http://localhost:8080/pokemon/" + pokeId, {withCredentials:true})
        .then((response) => alert(response.data))
        .then(() => {getAllPokemon()})

        //TODO: error handling if the pokemon can't delete 
        //(unlikely since each delete button is associated with a valid pokeId)
    }

    return(
        
        <div className="collection-container">

            {/* For every pokemon in the array (called "p"), render a Pokemon Component with its data*/}
            {pokemon.map((p, index) => (
                <div key={index}>
                    <Pokemon pokemon={p} />
                    <button className="poke-button" onClick={() => deletePokemon(p.pokeId)}>Delete</button>
                </div>
            ))}

        </div>
    )

}