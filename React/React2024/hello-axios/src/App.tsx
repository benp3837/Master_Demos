import React from 'react';
import logo from './logo.svg';
import logoo from '../public/logo192.png'
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { Login } from './components/Login/Login';
import { Home } from './components/Catch/Home';
import { Collection } from './components/Collection/Collection';

function App() {
  return (
    //To make a component show up when the application starts, you can put the path as "" 
    //Notice I close the two different <Route> tags differently. Both are valid. I prefer the second way.
    <div className="App">

        <BrowserRouter>
          <Routes>
            <Route path="" element={<Login/>}></Route> 
            <Route path="/catch" element={<Home/>}/>
            <Route path="/collection" element={<Collection/>}/>
          </Routes>
        </BrowserRouter>
    </div>
  );
}

export default App;
