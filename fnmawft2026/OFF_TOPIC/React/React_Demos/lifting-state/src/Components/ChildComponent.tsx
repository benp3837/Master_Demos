//look at the props!!

export const ChildComponent:React.FC<any> = ({incrementCounter}) => {


    return(
        <>
            <div style={{"border":"solid 2px", "padding":"5px"}}>
                <p>child component</p>
                <button onClick={incrementCounter}> +1 </button>
            </div>
        </>
    )

}