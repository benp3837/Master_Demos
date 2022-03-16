import React from 'react';
import './App.css';
import { FirstClassComponent } from './components/FirstClassComponent/FirstClassComponent';
import { ParentComponent } from './components/ParentComponent/ParentComponent';
import { UserComponent } from './components/UserComponent/UserComponent';

//what does the App() function do?
function App() {
  //what does this mean?
  return (
    //what happens if there's nothing in the return?
    <div className="App">
      <h1>Hello React!</h1>
      <FirstClassComponent/>
      <ParentComponent/>
      <UserComponent/>
    </div>
  );
}

//what's this?
export default App;
