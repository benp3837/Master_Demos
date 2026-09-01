//This component will render multiple Character components that just lay out some character data

import { useEffect, useState } from "react"
import { CharacterInterface } from "../../Interfaces/CharacterInterface"
import { Character } from "./Character"

//We can render a list of elements with the map() function
export const CharacterList:React.FC = () => {

    //State object that holds an Array of Character data
    //This Array will get populated whe the component renders thanks to useEffect
    const [characters, setCharacters] = useState<CharacterInterface[]>([])

    /*useEffect can listen for events to trigger some functionality
    Here, we'll just have it execute some code when the component renders
    
    Imagine we send a GET request to some API that gets our list of characters
    But for now, we'll just hardcode it :) we'll see axios in P1demo */
    useEffect(() => {

        //set the characters state Array to hold some Harry Potter characters
        //This is where the GET request would happen if we weren't hardcoding
        setCharacters(
            [
                {
                    name:"Dobby",
                    quote:"Master has given Dobby a sock :)"
                },
                {
                    name:"Voldemort",
                    house:"Slytherin",
                    quote:"The boy who lived... come to die"
                },
                {
                    name:"Snape",
                    house:"Slytherin",
                    quote:"MISTA POTTA"
                }
            ]
        )
    }, []) //we added [] as the second param, which means this useEffect will invoke once the component loads


    return(
        <div>
            <h3>Character List: </h3>

            {/* using map() to render a Character Component for every character in the Array 
            We're using the index of the Array as the map's key (should probably use a characterId)*/}
            <div>
                {characters.map((character:CharacterInterface, index:number) => {
                    return <Character {...character} key={index}/>
                })}
            </div>

            {/* What's happening here?^ 
            -Iterating (mapping) through the characters Array
            -For every CharacterInterface object in the Array, render one Character components
            -We must include the spread operator (...) if we want to pass in an entire object
            
            Why do we need the spread operator?
            It "spreads" the object out into individually accessible variables
            So it's just a requirement, we can't add the object unless we make destructure variables like this*/}

        </div>
    )
}