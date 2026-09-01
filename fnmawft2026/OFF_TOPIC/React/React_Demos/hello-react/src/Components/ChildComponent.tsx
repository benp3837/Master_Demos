/* This component takes props of ChildProps type. What is that, and what is props?

Props (short for "properties") is the data sent in from a Parent Component
ParentComponent will render a ChildComponent in its return() and pass some values to it

We defined an Interface (which is like a Java Model Class) to define the Child's props
We can then use these values once they're sent in from the Parent.
*/
interface ChildProps{
    color:string
    song:string
}

//Note: Specifying ChildProps as props type, and {color, song} which are the actual values
export const ChildComponent:React.FC<ChildProps> = ({color, song}) => {

    

    return(
        <>
            <h4>Hello from the Child Component!</h4>
            <p>My Parent's favorite color is: {color}</p>
            <h5>My Parent's favorite song is: {song}</h5>
        </>
    )
}