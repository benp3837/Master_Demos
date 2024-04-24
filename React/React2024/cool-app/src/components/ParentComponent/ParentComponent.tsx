import { useState } from "react"
import { ChildComponent } from "../ChildComponent/ChildComponent"

export const ParentComponent: React.FC = () => {


/*  State is an object that stores data that can easily be passed to a child component

    useState allows us to store and manipulate a component's state
    We declare: 
        1) A variable to access the state 
        2) A mutator (like a setter) to change the state value, 
        3) A default value within the actual useState()

    So now, we can access and change state! */
    let[favColor, setColor] = useState('green')
    let[favAnimal, setAnimal] = useState('dog')


    /*we will nest a child component in this parent component to demonstrate props/state
    the parent will send state data to the child (color and animal).
    We always send the parent's state to the child's props, never the other way around*/
    return(
        <div>
            <h1>Hello from the Parent Component! My favorite color is: {favColor}</h1>
            <ChildComponent color={favColor} animal={favAnimal}></ChildComponent>
        </div>
    )
}