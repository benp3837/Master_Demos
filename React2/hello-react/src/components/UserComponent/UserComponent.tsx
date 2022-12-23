import React from "react"

import { UserInterface } from "../../interfaces/UserInterface"
import { PostComponent } from "../PostComponent/PostComponent";

//Because we only ever intend to use data found in IUser, we'll put UserInterface as the state type
export class UserComponent extends React.Component<any, UserInterface> {

     //constructor that initializes the User's variables to empty strings (we'll change later)
     constructor(props:any){
        super(props);
        this.state = {
            firstName: "",
            lastName: "",
            username: "",
            email: ""
        }
    }

    //The componentDidMount() lifecycle method is usually used for populating data after page load
    //in other words... once this component is rendered, the body of this method will execute
    componentDidMount(){
        //hardcoding - but imagine we're making a call to a server that populates this user data. login?
        //to set the variables of the state object, we use this.setState(). 
        this.setState(
            {
                firstName: "Bon",
                lastName: "Jovi",
                username: "bigbon",
                email: "email@fakemail.com"
            }
        )
    }
    //big picture of this code block: 
    //when this component renders, the state will be set due to the code executing in componentDidMount()
    //we the state object in this component to be a UserInterface object

    //as usual, we need a render function that renders the view of this ClassComponent
    render() {
        return(
            <div>
                <h2>User: {this.state.firstName} {this.state.lastName} </h2>
                   <h2>Email: {this.state.email}</h2>
                <PostComponent {...this.state}/>
            </div>
        )
        //to send the entire state object to a child component, we use {...this.state}
    }

}