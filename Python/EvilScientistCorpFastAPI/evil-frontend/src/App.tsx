import './App.css'
import { Dashboard } from './Components/Dashboard'
import { FirstComponent } from './Components/FirstComponent'
import { BrowserRouter, Route, Routes } from 'react-router-dom'

function App() {

  return (
    <div className="container">

      {/* TODO: This login UI should be a component*/}

      <h1>Evil Scientist Corp.</h1>
      <div className="login-card">
        <input type="text" placeholder="username"/>
        <input type="password" placeholder="password" />
        <button>
          Login
        </button>
      </div>

      <br />
      <p>====================================================================</p>

      <h2>Hello React! We'll make great modern UIs with you :)</h2>
      <p>We are writing in TSX, which is like HTML for React with Typescript</p>
      <h3>React will reload the app with every saved change to the source code</h3>
      {/* This is a comment in TSX. 
      Calling a custom component below: */}

      <FirstComponent/>

      <BrowserRouter>
        <Routes>
          <Route path="/dashboard" element={<Dashboard/>}/>
        </Routes>
      </BrowserRouter>

    </div>

  )
}

export default App
