import axios from "axios";
import React, { useState } from "react";
import { PokemonInterface } from "../../interfaces/PokemonInterface"
import "./Home.css"
import { state } from "../../store";
import { Pokemon } from "../Pokemon/Pokemon";
import { useNavigate } from "react-router-dom";

export const Home: React.FC<any> = () => {

    const navigate = useNavigate()

    //we need a useState hook to store incoming Pokemon info, to send it to the PokemonComponent
    //setting an object in useState can be cleaner, but can complicate mutations... see below 
    const [pokemon, setPokemon] = useState<PokemonInterface>({
        name:"",
        number:0,
        type:"",
        image:"",
    })


    //a function that stores the user inputted PokeId (Which we need for our GET request)
    const gatherInput = (input:any) => {
        
        /* use the mutator to save the user-inputted ID to pokeId. 
        With an object stored in state, we must spread the original object (...) 
        ...and then specify which values to change. In this, pokeId. */
        setPokemon((pokemon) => ({...pokemon, number:input.target.value}))
    }

    //a function that makes an axios HTTP GET Request
    const getPokemon = async () => {

        console.log("state: " + state.JWT)

        //Getting a certain pokemon by its Id (using the pokeId state attribute)
        //remember, we need to AWAIT anything that returns a promise
        const response = await axios.get("https://pokeapi.co/api/v2/pokemon/" + pokemon.number, 
        {headers: {Authorization: "Bearer: " + state.JWT}})

        //note the Authorization header!!^^ You can set any header you want with the headers object

        console.log(response.data)

        //fill out the pokemon name/sprite state variables with the incoming data
        setPokemon((pokemon) => ({...pokemon, name: response.data.name}))
        setPokemon((pokemon) => ({...pokemon, image: response.data.sprites.front_default}))

    }

    return(
        <div className="home-page">   

            <div className="home-container">
                <h3>Search for your Pokemon</h3>
                <input type="number" name="pokeSearch" placeholder="Enter Pokemon Id" onChange={gatherInput}/>
                <button className="poke-button" onClick={getPokemon}>Find Pokemon</button>
                <Pokemon pokemon={pokemon}></Pokemon>
                <button className="poke-button" onClick={()=>{navigate("/collection")}}>See All Pokemon</button>
            </div>

        </div>
        //We're sending a prop called Pokemon to the Pokemon component. It contains our Pokemon state object defined above
    )

}