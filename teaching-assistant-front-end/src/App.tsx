import React from 'react';
import './App.css';
import {Grid} from "gymnast";

function App() {
  return (
    <div className="App">
      <header className="App-header">
      </header>
      <Grid justify={"center"}>
        <Grid direction={"column"} size={"fit"} margin={2} style={{background:"yellow"}}>Content Here</Grid>
        <Grid direction={"column"} size={"fit"} style={{background:"blue", color: "white"}}>More Content</Grid>
      </Grid>
    </div>
  );
}

export default App;
