import React, { useEffect, useState } from 'react';
import {useDispatch, useSelector} from 'react-redux';
import {getPoke} from '../../Actions/PostActions';
import { Poke } from '../PokeComponent/Poke'

import './Home.css';

export const Home: React.FC<any> = () => {

    const appState = useSelector<any, any>((state) => state);
    const dispatch = useDispatch();

    let [loading, setLoading] = useState(true);

    useEffect(() => {
        console.log(appState)
        if(appState.poke.id > 0){
            setLoading(false);
            loadPoke();
        }
        
    }, [appState.poke]);

    const loadPoke = async () => {
        console.log("in loadPoke")
        await dispatch(
            getPoke() as any
        );
    }

    //WEIRD>>>>> loading? should return false (it's only true til we get a poke)
    //so why does it seem to break the code to take out that conditional (error: appState.poke.map)
    return(
        <div className='home-page'>
            <div className='home-container'>
                {loading? <h1>loading</h1>: 
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