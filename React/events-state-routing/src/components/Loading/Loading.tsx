import React from 'react';

export function Loading(Component: React.ComponentType<any>){
    return(props: any) => {
        if(props.loading) return <p>Loading data</p>
        return <Component list={props.data} />
    }
}