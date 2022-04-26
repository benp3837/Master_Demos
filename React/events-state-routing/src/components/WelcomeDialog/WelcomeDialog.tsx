import React from 'react';

import { FancyBorder } from '../FancyBorder/FancyBorder';

import './WelcomeDialog.css';

export const WelcomeDialog: React.FC<any> = (props:any) => {
    return (
        <FancyBorder>
            <h1 className="dialog-title">{props.title}</h1>
            <p className="dialog-message">{props.message}</p>
            {props.children}
        </FancyBorder>
    )
}