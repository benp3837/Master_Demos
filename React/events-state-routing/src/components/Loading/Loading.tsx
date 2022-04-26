import React from 'react';

//this function is a key part of our higher order component pattern...
//it will first return our loading message, until eventually returning our HOCList
//see it working in our HOCHolder component!
export function Loading(Component: React.ComponentType<any>){
    return(props: any) => {
        if(props.loading) return <p>Loading data</p>
        return <Component list={props.data} />
    }
}