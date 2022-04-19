import React from 'react';

import './App.css';
import { HypotenuseComponent } from './components/HypotenuseComponent/HypotenuseComponent';
import { PostContainer } from './components/PostContainer/PostContainer';
import { data } from './data';

function App() {
  return (
    <div className="App">
      <HypotenuseComponent/>
      <PostContainer data={data}/>
    </div>
  );
}

export default App;
