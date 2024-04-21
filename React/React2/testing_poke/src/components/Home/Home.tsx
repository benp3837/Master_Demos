import axios from "axios";
import React, { useState } from "react"
import { Pokemon } from "../Pokemon/Pokemon";

import "./Home.css"

export const Home: React.FC<any> = () => {

    //we need useState to store pokemon info as state, and change it with it's mutator
    let [pokeID, setPokeID] = useState(0);
    let [pokeName, setPokeName] = useState("");
    let [pokeSprite, setPokeSprite] = useState("");

    //whenever pokeSearch changes, we'll save the number as our pokeID state (using the mutator)
    const handleChange = (e:any) => {
        if(e.target.name === "pokeSearch") {
            setPokeID(e.target.value) //use the mutator to get the value the user inputted
        }
    }

    //we need to actually send our pokeID state to the getPoke action
    const loadPoke = async () => {

        //default values object that will get populated with pokemon data
        let incomingPoke = {
            id: 0,
            name: "",
            sprite: ""
        };

        try{

            //making an axios HTTP request to GET a pokemon from pokeAPI, with the ID sent in
            //remember, we need to AWAIT async functions because they return a promise object
            const response = await axios.get("https://pokeapi.co/api/v2/pokemon/" + pokeID)

            //fill out the empty incomingPoke object with Pokemon data
            incomingPoke = {
                id: response.data.id,
                name: response.data.name,
                sprite: response.data.sprites.front_default
            }

            setPokeName(incomingPoke.name);
            setPokeSprite(incomingPoke.sprite);


        } catch (e) {
            console.log("GET POKE FAILED!!")
        }
    }

    return(
        <div className="home-page">
            <div className="home-container">
                <Pokemon name={pokeName} sprite={pokeSprite}/>
                <h3>Search for your Pokemon!</h3>
                <input type="number" name="pokeSearch" placeholder="Enter PokeID" onChange={handleChange}/>
                <button className="poke-button" onClick={loadPoke}>Find Pokemon</button>
            </div>
        </div>
    );
}