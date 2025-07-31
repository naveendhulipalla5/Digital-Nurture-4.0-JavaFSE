import React from 'react';
import Counter from './Counter';
import CurrencyConvertor from './CurrencyConvertor';

function App() {
  const sayMessage = (msg) => {
    alert(msg);
  };

  const handleClick = (event) => {
    alert("I was clicked");
  };

  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <h1>React Events Example</h1>
      
      <hr />
      <Counter />

      <hr />
      <button onClick={() => sayMessage("Welcome!")}>Say Welcome</button>

      <hr />
      <button onClick={handleClick}>Synthetic Event Button</button>

      <hr />
      <CurrencyConvertor />
    </div>
  );
}

export default App;
