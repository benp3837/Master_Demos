import React from 'react';

//routing dependencies, which we made available with: npm i --save-dev @types/react-router-dom
import {
  BrowserRouter as Router,
  Routes, Route, 
} from 'react-router-dom';

import './App.css';
import { HOCHolder } from './components/HOCHolder/HOCHolder';
import { HypotenuseComponent } from './components/HypotenuseComponent/HypotenuseComponent';
import { PostContainer } from './components/PostContainer/PostContainer';
import { SignUpDialog } from './components/SignUpDialog/SignUpDialog';
import { WelcomeDialog } from './components/WelcomeDialog/WelcomeDialog';
import { data } from './data';

function App() {
  return (
    <Router>

      <Routes>
        <Route path="/hyp" element={<HypotenuseComponent/>}/>
      </Routes>
      <Routes>
        <Route path="/posts" element={<PostContainer data={data}/>} />
        <Route path="/HOC" element={<HOCHolder/>}/>
        <Route path="/welcome" element={<SignUpDialog />}/>
      </Routes>

    </Router>
  );
}

export default App;
