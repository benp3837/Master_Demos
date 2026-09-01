import { useState } from "react"
import { ChildComponent } from "./ChildComponent"
import { CoolerChildComponent } from "./CoolerChildComponent"

export const ParentComponent:React.FC = () => {

    const [counter, setCounter] = useState<number>(0)

    //The child component will get this function as props
    const incrementCounter = () => {
        setCounter(counter + 1) //state changes here!
    }

    return(
        <>
            <div style={{"border":"solid 2px", "padding":"5px"}}>
                <p>parent component - </p>
                <p style={{"color":"blue"}}>I passed the children my incrementCounter function as props!</p>
                <p>COUNTER: {counter}</p>
            </div>
            
            {/* Child and CoolerChild are siblings - children of ParentComponent. */}
            <div style={{"display":"flex"}}>
                <ChildComponent incrementCounter={incrementCounter}/>
                <CoolerChildComponent incrementCounter={incrementCounter}/>
            </div>
        </>
    )

}