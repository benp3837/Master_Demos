import React, { useEffect, useState } from "react";
import { UserInterface } from "../../interfaces/UserInterface";
import { PostComponent } from "../PostComponent/PostComponent";

//This component has props of "any" so it could take any data from a parent class (none in this case)
export const UserComponent: React.FC<any> = () => {

    //Defining a useState hook for user data defined in UserInterface. 
    //Setting the values to empty strings for now 
    const [user, setUser] = useState<UserInterface>({
        firstName: '',
        lastName: '',
        username: '',
        email: ''
    });


    //useEffect is a HOOK often used for populating data after the component loads (on mount)
    //but this can pretty much be used to execute ANY kind of logic as soon as the component renders

    //hardcoding - but imagine we're making some HTTP call to a server (with axios) which grabs user data 
    //(maybe login?) to set the fields of the state object in the component
    useEffect(() => {
        setUser({
            firstName: 'Bonjamin',
            lastName: 'P',
            username: 'BigBon',
            email: 'reactluvr111@gmail.com'
        });
    }, []); // Empty dependency array means this effect runs once on mount


    //as usual, we need a return method that renders the view of this component
    return(
        <div>
            <h2>User: {user.firstName} {user.lastName}</h2>
            <h3>Email: {user.email}</h3>
            <PostComponent {...user}></PostComponent>
        </div>
        //to send the entire state object to a child's props, we can use {...this.state}
        //...is like saying "all of this" "the entire state object"
    )

}