import React from 'react';
import logo from './logo.svg';
import './App.css';
import { EmployeeContainerComponent } from './components/EmployeeContainerComponent/EmployeeContainerComponent';
import { data } from './data';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { MultiplyComponent } from './components/HypotenuseComponent/MultiplyComponent';


//To establish routes, we need <BrowserRouter>, followed by <Routes>, followed by individual Route(s) 
//<Route> needs: a path (the URL to reach the component) & an element (the component to render)
function App() {
  return (
    <div className="App">

      <h3 style={{backgroundColor: "white"}}>Welcome. Imagine I'm a navbar that you could click to change the URL to a valid endpoint. We'll see the useNavigate() hook in the next demo</h3>


    <BrowserRouter>
      <Routes>
        <Route path="/emp" element={<EmployeeContainerComponent data={data}/>}></Route>
        <Route path="/mult" element={<MultiplyComponent/>}></Route>
      </Routes>
    </BrowserRouter>

    </div>
  );
}

export default App;
