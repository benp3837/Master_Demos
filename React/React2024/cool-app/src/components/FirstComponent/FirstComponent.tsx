/*Recall how arrow functions work. they take in some arguments, and execute some code
In our first component, we're sending in no arguments, hence the empty ()
React Components take two arguments, props and state, which we'll see later*/
export const FirstComponent: React.FC = () => {

    //we will databind the value of this String below
    let words:String = "I am stored in a variable in a component";


    //the return() function holds TSX - what the component will actually display (aka render) onto the webpage
    return(
        <div>
            <h3>Hello from our first component!</h3>
            <p>Data bound value: {words}</p>
        </div>
    )

}