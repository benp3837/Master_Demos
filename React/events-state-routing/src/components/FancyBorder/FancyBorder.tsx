import React from 'react';

//This component will let us demonstrate CONTAINMENT
//Which is like Java generics
//We can pass whatever child class we want through this props
export const FancyBorder: React.FC<any> = (props:any) => {
    return <div className={'fancy-border fancy-border-blue'}>
        {props.children}
    </div>
}