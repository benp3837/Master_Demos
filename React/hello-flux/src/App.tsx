import React from 'react';

import { HashRouter as Router, Routes, Route } from 'react-router-dom';
import {Login} from './Components/LoginComponent/Login';

import './App.css';
import { Home } from './Components/HomeComponent/Home';

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path='/' element={<Login/>}/>
          <Route path='/home' element={<Home/>}/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
