import React from 'react';

import { FancyBorder } from '../FancyBorder/FancyBorder';

import './WelcomeDialog.css';

export const WelcomeDialog: React.FC<any> = (props:any) => {
    return (
        <FancyBorder>
            <h1 className='dialog-text'>Welcome</h1>
            <p className='dialog-message'>Thank you for visiting this page. +20 Revature points</p>
        </FancyBorder>
    )
}