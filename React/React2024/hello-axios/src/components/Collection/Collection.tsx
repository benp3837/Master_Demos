import { useEffect, useState } from "react"
import { PokemonInterface } from "../../interfaces/PokemonInterface"
import { Pokemon } from "../Pokemon/Pokemon"
import "./Collection.css"

export const Collection: React.FC<any> = () => {

    //we need a useState hook to store incoming Pokemon info, to send it to the PokemonComponent
    //setting an object in useState can be cleaner, but can complicate mutations... see below 
    const [pokemon, setPokemon] = useState<PokemonInterface[]>([])

    //useEffect will send a GET request to the server to get all pokemon from the database
    useEffect(() => {

        //TODO: for every pokemon returned in the get all, add it to the pokemon state array

        //populate the pokemon state object, giving us an Array of the user's pokemon
        setPokemon([
            { name: "Pikachu", number: 1, type: "Electric", image: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png" },
            { name: "Bulbasaur", number: 1, type: "Grass/Poison", image: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png" },
            { name: "Charmander", number: 1, type: "Fire", image: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png" },
            { name: "Pikachu", number: 1, type: "Electric", image: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png" },
            { name: "Bulbasaur", number: 1, type: "Grass/Poison", image: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png" },
            { name: "Charmander", number: 1, type: "Fire", image: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png" },
            { name: "Pikachu", number: 1, type: "Electric", image: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png" },
            { name: "Bulbasaur", number: 1, type: "Grass/Poison", image: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png" },
            { name: "Charmander", number: 1, type: "Fire", image: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png" },
            { name: "Pikachu", number: 1, type: "Electric", image: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png" },
        ])

    }, []) //remember, [] means this functionality triggers on page load


    return(
        <div className="collection-container">
            {pokemon.map((p, index) => (
                <Pokemon key={index} pokemon={p}></Pokemon>
            ))}
        </div>
    )

}