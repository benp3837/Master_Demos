import React, {useState, useEffect} from 'react';

import { WelcomeDialog } from '../WelcomeDialog/WelcomeDialog';

//using SPECIALIZATION!! which is making a component that's like a "specific" version of another
export const SignUpDialog: React.FC<any> = (props:any) => {
    let [login, setLogin] = useState('');

    const handleChange = (e:any) => {
        setLogin(e.target.value);
    }

    const handleSignup = () => {
        alert(`Welcome aboard, ${login}, you don't know what you got yourself into...`);
    }

    return (
        <WelcomeDialog title="Big Bad Hypotenuse Calculator"
                       message="How should we refer to you?">
            <input value={login} onChange={handleChange} />
            <button onClick={handleSignup}>Sign Me Up!</button>
        </WelcomeDialog>
    )
}