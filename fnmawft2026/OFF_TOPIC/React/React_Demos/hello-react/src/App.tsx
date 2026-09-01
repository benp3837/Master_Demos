import './App.css'
import { FirstComponent } from './Components/FirstComponent'
import { ParentComponent } from './Components/ParentComponent'


/* The App.tsx is the root of our app (at least when it comes to rendering views on the page) 

Most of the code we write will go elsewhere in the src folder, but App.tsx controls WHAT gets rendered

We'll put any components we want to render in the return() of App.tsx */

function App() {

  return (
    <>
      <h3>Hello React! We'll make great modern UIs with you :)</h3>

      <p>We are writing TSX, which is mostly like HTML, but it's for React. There are small differences</p>

      {/* This is a comment in TSX */}

      <h4>React will reload the app with every saved change to the source code. </h4>

      {/* Rendering some custom components below */}

      <FirstComponent/>
      <ParentComponent/>

    </>
  )
}

export default App
