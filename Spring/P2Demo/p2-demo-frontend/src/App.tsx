import React from 'react';
import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { Login } from './components/LoginRegister/Login';
import { Register } from './components/LoginRegister/Register';
import { Car } from './components/Car/Car';
import { CarContainer } from './components/Car/CarContainer';
import 'bootstrap/dist/css/bootstrap.min.css'; // Importing Bootstrap CSS globally
import { AddCar } from './components/Car/AddCar';
import { UsersContainer } from './components/User/UsersContainer';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
          <Routes>
              <Route path="" element={<Login/>}/>
              <Route path="/register" element={<Register/>}/>
              <Route path="/cars" element={<CarContainer/>}/>
              <Route path="/addcar" element={<AddCar/>}/>
              <Route path="/users" element={<UsersContainer/>}/>
          </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
