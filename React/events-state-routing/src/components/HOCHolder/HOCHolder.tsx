import React, {useEffect, useState} from 'react';

import {data} from '../../data';

import {HOCList} from '../HOCList/HOCList';
import {Loading} from '../Loading/Loading';

//Here's our Higher Order Component getting returned!
//goes into our Loading component - the function that returns HOCList with more functionality
const ListWithLoading = Loading(HOCList);

//BETTER COMMENT THIS WELL... THIS IS ALL STUFF YOU RECOGNIZE
export const HOCHolder:React.FC<any> = () => {

    //instantiate an empty array that can hold ANYTHING!
    let arr: any[] = [];

    let [loading, setLoading] = useState(true);
    let [pass, setPass] = useState({loading: true, data:arr});

    useEffect(() => {
        console.log(pass.loading);
        setTimeout(()=> {
            setPass({loading: false, data:data});
        }, 5000)
    }, [loading]);

    return <ListWithLoading {...pass} />

}