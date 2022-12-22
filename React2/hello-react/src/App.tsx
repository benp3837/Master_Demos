import React from 'react';
import './App.css';
import { FirstClassComponent } from './components/FirstClassComponent/FirstClassComponent';
import { ParentComponent } from './components/ParentComponent/ParentComponent';

/*
The App.tsx is our MAIN PAGE in React. This is where the root of our application it
Most of our coding will be done elsewhere, but this acts as the brain of our React app.
We put the components we want to render in the div in the return() of this file. 
We can also render standard TSX directly inside the div in the return()
*/

function App() {
  return (
    <div className="App">
      <h1>Hello React</h1>
      <p>we're writing in TSX, which is like HTML for React</p>
      <br />
      <FirstClassComponent></FirstClassComponent>
      <br />
      <ParentComponent></ParentComponent>
    </div>
  );
}

export default App;