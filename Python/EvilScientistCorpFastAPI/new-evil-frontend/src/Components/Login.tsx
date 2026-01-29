import React from "react"
import { useNavigate } from "react-router-dom"

export const Login:React.FC = () => {

    const navigate = useNavigate()

    return(
        <div className="container">
            <h1>Evil Scientist Corp.</h1>
            <div className="login-card">
                <input type="text" placeholder="username"/>
                <input type="password" placeholder="password" />
                <button onClick={() => navigate("/dashboard")}>
                Login
                </button>
            </div>
        </div>
    )

}