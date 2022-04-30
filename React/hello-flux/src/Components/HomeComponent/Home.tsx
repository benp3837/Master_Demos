import React, { useEffect, useState } from 'react';
import {useDispatch, useSelector} from 'react-redux';
import {getPoke} from '../../Actions/PostActions';
import { Poke } from '../PokeComponent/Poke'

import './Home.css';

export const Home: React.FC<any> = () => {

    const appState = useSelector<any, any>((state) => state);
    const dispatch = useDispatch();

    let [loading, setLoading] = useState(true);
    let [pokeID, setPokeId] = useState(0);


    useEffect(() => {
        console.log(appState)
        console.log("poke in appState, id: " + appState.poke.id )
        console.log("appstate poke: " + appState.poke.name)
        if(appState.poke.id > 0){
            
            setLoading(false);
            //loadPoke();
        }
        
    }, [appState.poke]);

    const handleChange = (e:any) => {
        if(e.target.name === "pokeSearch") {
            setPokeId(e.target.value);
        } 
    }

    const loadPoke = async () => {
        console.log("in loadPoke")
        await dispatch(
            getPoke(pokeID) as any
        );
    }

    return(
        <div className='home-page'>
            <div className='home-container'>
                <input type="number" name="pokeSearch" placeholder="enter pokeID" onChange={handleChange}/>
                <button className="poke-button" onClick={loadPoke}>Catch 'em all!</button>
                <Poke poke={appState.poke} />           
            </div>
        </div>
    );
    
}