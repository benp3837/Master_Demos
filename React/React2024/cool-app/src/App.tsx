import React from 'react';
import logo from './logo.svg';
import './App.css';
import { FirstComponent } from './components/FirstComponent/FirstComponent';
import { ParentComponent } from './components/ParentComponent/ParentComponent';
import { UserComponent } from './components/UserComponent/UserComponent';

/* The App.tsx is the root of our application (at least when it comes to component rendering)
Most of our coding will be done elsewhere, but the App.tsx lets us control WHAT gets rendered
We put the components we want to render in the div of the return() in this file
We can render standard TSX directly inside the div in the return() */

/* Some TSX quirks:
 className instead of class attribute 
 comments in TSX are block comments, like the one we're in */
function App() {
  return (
    <div className="App">

    <h1>Hello React! You're cool.</h1>
    <p>We are writing in TSX, which is like HTML for React Typescript</p>
    <h3>React will reload the webpage with every change</h3>

    <FirstComponent></FirstComponent>
    <ParentComponent></ParentComponent>
    <UserComponent></UserComponent>

  </div>
  );
}

export default App;
