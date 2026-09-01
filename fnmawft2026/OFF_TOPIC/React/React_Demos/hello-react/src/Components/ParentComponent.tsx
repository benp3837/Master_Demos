import { useState } from "react"
import { ChildComponent } from "./ChildComponent"

export const ParentComponent:React.FC = () => {

    /* We can use the "useState" hook to define state 
    State is an object that stores data related to a component
    
    Why not just use a regular variable?
    -The main advantage is that your component will re-render if state changes

    -If you want a value that directly effects the view, it will usually be a state object
    -If it's just a value you're using for a calculation etc, it's fine to leave it as a regular variable

    To use state in a component, we declare:
        1) A variable that lets us ACCESS the state value
        2) A mutator (like a setter in Java) lets us change the state value
        3) The actual "useState" hook, which initializes state and lets us set datatype/default value
    */
    const [favColor, setColor] = useState<string>("Blue")
    const [favSong, setSong] = useState<string>("No Quarter")


    //We can establish parent/child relationships by rendering a component inside another component
    return(
        <>
            <h3>Hello from the Parent Component. My Child says:</h3>
            <ChildComponent color={favColor} song={favSong}/>
        </>
    )
}