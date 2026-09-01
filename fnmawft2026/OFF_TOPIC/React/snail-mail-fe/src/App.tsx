import { useState } from 'react'
import './App.css'
import { Inbox } from './components/Inbox'
import 'bootstrap/dist/css/bootstrap.css'
import { Compose } from './components/Compose'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import { UserProfile } from './components/UserProfile'
import { ErrorPage } from './components/ErrorPage'

//Welcome to App.tsx! This is the main component of our React App
//Any other components we create will rendered here before they are visible
function App() {

  //useState object to hold showCompose, and a toggler to switch its value between true/false
  const [showCompose, setShowCompose] = useState<boolean>(false)
  const toggleShowCompose = (() => {setShowCompose(!showCompose)})

  {/* the return() of a component is just the view. what the component looks like */}
  return (
    <div>

      <BrowserRouter>

      {/* Simple Top Navbar */}
      <nav className="border-bottom mb-5">
        <h2 className="font-monospace">🐌 SnailMail 🐌</h2>
      </nav>

      {/* Routes - these components will only render when their endpoint is in the URL */}
      <Routes>
          <Route path="/" element={<Inbox/>}/> {/* This component renders by default */}
          <Route path="profile" element={<UserProfile/>}/>
          <Route path="*" element={<ErrorPage/>}/> {/* This component renders for any URL endpoint that isn't listen in the Routes */}
      </Routes>

      {/* We'll define a boolean variable called showCompose.
          If showCompose is true, show the Compose component.
          If showCompose is false, show the button that opens the Compose component 
        NOTICE: the data attribute - it'll help us select the Compose component for our tests */}
      {showCompose ? <Compose data-testid="compose-component" onClose={toggleShowCompose}/> 
      : <button className="btn btn-sm btn-outline-primary" onClick={toggleShowCompose}>Compose Email</button>}

      </BrowserRouter>
    </div>
  )
}

export default App
