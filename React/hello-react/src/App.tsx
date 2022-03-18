import React from 'react';
import './App.css';
import { FirstClassComponent } from './components/FirstClassComponent/FirstClassComponent';
import { ParentComponent } from './components/ParentComponent/ParentComponent';
import { UserComponent } from './components/UserComponent/UserComponent';

//The App.tsx file is where we put what we want displayed on the webpage
//You can add standalone JSX/TSX, or entire components
function App() {
  //We put what we want to display in this return() method
  return ( 
    <div className="App">
      <h1>Hello React!</h1>
      <FirstClassComponent/>
      <ParentComponent/>
      <UserComponent/>
    </div>
  );
}

//This lets us export this App.tsx to potentially be used in other modules
export default App;
