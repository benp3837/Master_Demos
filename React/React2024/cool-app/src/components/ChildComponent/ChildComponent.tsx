/*In this compoennt, props is of <any>, type. This allows ANY type of data to be sent in to the component.
Why? It's good for scalability/flexibility. We could specify props of a specific data type if we wanted.*/

//ParentComponent will send a state containing color and animal. ChildComponent accepts props of "any" type.
//The state coming from the ParentComponent will ALWAYS be the props in the ChildComponent
export const ChildComponent: React.FC<any> = ({color, animal}) => {

    /*What is ({color, animal})? This is called DESTRUCTURING.
    We're breaking apart the incoming state object that was passed in as props.
    Destructuring essentially lets us break up a props object into individual variables.
    The name inside the curly braces must match the variable in the props that was sent in!! 
    See the color and animal variables being used in the return() below */


    //note the sly use of inline styling with the color variable
    return(
        <div>
            <h3>Hello from the Child Component</h3>
            <h3 style={{color}}>My parent's fav color is: {color}</h3>
            <h4>My parent's fav animal is: {animal}</h4>
        </div>
    )
}