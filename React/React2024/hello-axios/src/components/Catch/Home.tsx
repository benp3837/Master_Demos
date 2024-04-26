import axios from "axios";
import React, { useState } from "react";
import { PokemonInterface } from "../../interfaces/PokemonInterface"
import "./Home.css"
import { state } from "../../store";
import { Pokemon } from "../Pokemon/Pokemon";
import { useNavigate } from "react-router-dom";

export const Home: React.FC<any> = () => {

    const navigate = useNavigate()

    //stores the user input when they search for a pokemon
    let userInput:number = 0

    //we need a useState hook to store incoming Pokemon info, to send it to the PokemonComponent
    //setting an object in useState can be cleaner, but can complicate mutations... see below 
    const [pokemon, setPokemon] = useState<PokemonInterface>({
        name:"",
        image:"",
    })


    //a function that stores the user inputted PokeId (Which we need for our GET request)
    const gatherInput = (input:any) => {
        
        userInput = input.target.value
    }

    //a function that makes an axios HTTP GET Request to get a pokemon from pokeAPI
    const getPokemon = async () => {

        console.log("state: " + state.JWT)

        //Getting a certain pokemon by its Id (using the pokeId state attribute)
        //remember, we need to AWAIT anything that returns a promise
        const response = await axios.get("https://pokeapi.co/api/v2/pokemon/" + userInput, 
        {headers: {Authorization: "Bearer: " + state.JWT}})

        //note the Authorization header!!^^ You can set any header you want with the headers object

        console.log(response.data)

        //fill out the pokemon name/sprite state variables with the incoming data
        setPokemon((pokemon) => ({...pokemon, name: response.data.name}))
        setPokemon((pokemon) => ({...pokemon, image: response.data.sprites.front_default}))

    }

    //a function that sends a pokemon object to the backend
    const catchPokemon = async () => {

        //hardcoding every pokemon to user 1 until we talk about login
        const response = await axios.post("http://localhost:8080/pokemon/1", pokemon)

        alert(response.data.user.username + " caught " + response.data.name)

    }


    return(
        <div className="home-page">   

            <div className="navbar">
                <button className="poke-button" onClick={()=>{navigate("/collection")}}>See All Pokemon</button>
                <button className="poke-button" onClick={()=>{navigate("/")}}>Back to Login</button>
            </div>

            <div className="home-container">
                <h3>Search for your Pokemon</h3>
                <input type="number" name="poke-search" placeholder="Enter Pokemon Id" onChange={gatherInput}/>
                <button className="poke-button" onClick={getPokemon}>Find Pokemon</button>

                <div className="poke-container">
                    {pokemon.name ? <button className="poke-button" onClick={catchPokemon}>Catch</button>:''}
                    <Pokemon pokemon={pokemon}></Pokemon>
                </div>
            </div>

        </div>
        //We're sending a prop called Pokemon to the Pokemon component. It contains our Pokemon state object defined above
    )

}