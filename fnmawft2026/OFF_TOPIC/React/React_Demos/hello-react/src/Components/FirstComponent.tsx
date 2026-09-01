/* Recall how Arrow Functions work - they can take in values, and execute some code. 
Our React Components will all be arrow functions (Functional Components)
In this Component, we're providing no arguments, hence the empty () => 

"export" - We need this so our Component can be imported around the App (App.tsx?)
"const" - The component can't be reassigned, changed, etc. 
"React.FC" - We're saying this is a React (F)unction (C)omponent
    -Basically we're defining what datatype this function returns */
export const FirstComponent:React.FC = () => {

    //We can define variables and logic in the space above the return()
    const message:string = "I am a value stored in FirstComponent, and rendered in TSX."

    //we can use {data binding} to render variable values onto our view

    return(
        <>
            <h4>Hello from FirstComponent</h4>
            <p>Data Binding: {message}</p>
        </>
    )

}