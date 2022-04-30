import React from 'react';

import './Poke.css';

export const Poke: React.FC<any> = (props) => {

    return(
        <div className='post-container'>
            <div className='content'>
                <p>{props.name}</p>
            </div>
        </div>
    )
}