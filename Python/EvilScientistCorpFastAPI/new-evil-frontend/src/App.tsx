import './App.css'
import { Dashboard } from './Components/Dashboard'
import { FirstComponent } from './Components/FirstComponent'
import { BrowserRouter, Route, Routes} from 'react-router-dom'
import { Login } from './Components/Login'

function App() {

  return (
    <div className="container">


      <h2>Hello React! We'll make great modern UIs with you :)</h2>
      <p>We are writing in TSX, which is like HTML for React with Typescript</p>
      <h3>React will reload the app with every saved change to the source code</h3>
      {/* This is a comment in TSX.  */}
      <p>Calling a custom component below:</p>

      <FirstComponent/>

      <br />
      <p>Sample Log in Below. Click the login button!=======================================</p>
  

      {/* ROUTING - how we DYNAMICALLY render components
      Routing is URL-based. We can render certain components by changing the URL.
      
      To define a route, we need:
        -The path, which specifies the URL that will show a particular component
        -The element, which specifies the component that will render at that URL */}
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login/>}/>
          <Route path="/dashboard" element={<Dashboard/>}/>
        </Routes>
      </BrowserRouter>

    </div>

  )
}

export default App
