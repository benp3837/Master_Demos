import React from 'react';

import './Poke.css';

export const Poke: React.FC<any> = (props) => {

    console.log("props: " + props.poke.name)

    let pokePic:any = props.poke.sprite;

    return(         
            <div className='content'>
                    <img src={pokePic} alt="something"/> <h3>{props.poke.name}</h3>
            </div>
    )
}