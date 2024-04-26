import { useState } from "react"
import { useNavigate } from "react-router-dom"
import { UserInterface } from "../../../interfaces/UserInterface"
import axios from "axios"

export const Register: React.FC<any> = () => {

    const[user, setUser] = useState<UserInterface>({
        username:'',
        password:''
    })

    const navigate = useNavigate()


    const storeValues = (input:any) =>{
        if(input.target.name === "username"){
            setUser((user) => ({...user, username:input.target.value}))
        } else {
            setUser((user) => ({...user, password:input.target.value}))
        }
    }


    const register = async () => {

        try {
            const response = await axios.post('http://localhost:8080/auth', user);
            console.log(response.data);

            alert(response.data)
            navigate("/")
          } catch (error) {
            alert("Failed to create user!")
          }

    }



    return(
        <div className="login">

        <div className="text-container">
            <h1>New here? Create an Account for free!</h1>

            <div className="input-container">
                <input type="text" placeholder="username" name="username" onChange={storeValues}/>
            </div>
            <div className="input-container">
                <input type="password" placeholder="password" name="password" onChange={storeValues}/>
            </div>


            <button className="login-button" onClick={register}>Submit</button>
            <button className="login-button" onClick={() => navigate("/")}>Back</button>

        </div>

        </div>
    )

}