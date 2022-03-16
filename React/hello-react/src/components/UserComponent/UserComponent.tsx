import React from "react";

import { UserInterface } from "../../interfaces/UserInterface";

export class UserComponent extends React.Component<any, UserInterface> {

    //constructor that initializes the User variables to empty Strings (for now...)
    constructor(props:any){
        super(props);
        this.state = {
            firstName: '',
            lastName: '',
            username: '',
            email: ''
        }
    }

    //who remembers? This lifecycle function is usually used for populating data after page load
    //in other words... upon initialization, the body of this function will execute.
    componentDidMount(){
        //Imagine we're making a call to an api here to populate this info
        this.setState({
            firstName: 'Bon',
            lastName: 'Petruzziello',
            username: 'bigbon',
            email: 'fakeemail@fake.com'
        });
    }

    //and of course... a render function that does what?
    //we're gonna use it to render the user data onto our webpage
    public render(){
        return(
            <div>
                <h2>{this.state.firstName} {this.state.lastName}</h2>
                <h3>{this.state.username}</h3>
                <h3>{this.state.email}</h3>
            </div>
        );
    }

}