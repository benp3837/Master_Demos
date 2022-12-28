import React from 'react';
import {Routes, Route, BrowserRouter} from 'react-router-dom';

import './App.css';
import { HypotenuseComponent } from './components/HypotenuseComponent/HypotenuseComponent';
import { PostContainerComponent } from './components/PostContainerComponent/PostContainerComponent';
import { data } from './data';

//Remember, App.tsx is the main page we'll render stuff on. 
//We can render TSX directly in the return(), or render entire Components 

/*Note the syntax for Routing:
The Router holds the different Routes tags, which each hold a different Route
The Route tag will hold a url path and the component that gets rendered on that url */
export function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/hyp" element={<HypotenuseComponent/>}/>
        </Routes>
        <Routes>
        <Route path="/posts" element={<PostContainerComponent data={data}/>}></Route>
      </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
