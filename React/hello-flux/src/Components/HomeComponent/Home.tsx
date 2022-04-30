import React, { useEffect, useState } from 'react';
import {useDispatch, useSelector} from 'react-redux';
import {getPoke} from '../../Actions/PostActions';
import { Poke } from '../PokeComponent/Poke'

import './Home.css';

export const Home: React.FC<any> = () => {

    const appState = useSelector<any, any>((state) => state);
    const dispatch = useDispatch();

    let [loading, setLoading] = useState(true);
    let [pokeID, setPokeId] = useState(5);


    useEffect(() => {
        console.log(appState)
        console.log("poke in appState, id: " + appState.poke.id )
        if(appState.poke.id > 0){
            setLoading(false);
            loadPoke();
        }
        
    }, [appState.poke]);

    const handleChange = (e:any) => {
        if(e.target.name === "pokeSearch") {
            console.log("handleChange: " + e.target.value)
            setPokeId(e.target.value);
        } 
    }

    const loadPoke = async () => {
        console.log("in loadPoke")
        await dispatch(
            getPoke(pokeID) as any
        );
    }

    //WEIRD>>>>> loading? should return false (it's only true til we get a poke)
    //so why does it seem to break the code to take out that conditional (error: appState.poke.map)
    return(
        <div className='home-page'>
            <div className='home-container'>
                {loading? <input type="number" name="pokeSearch" placeholder="enter pokeID" onChange={handleChange}/>
                : 
                    appState.poke.map((poke:any) => {
                        return (
                            <Poke poke={appState.poke} key={poke.pokeId}/>
                        )
                    })
                }
            </div>
            <button className="poke-button" onClick={loadPoke}>Catch 'em all!</button>
        </div>
    )
}