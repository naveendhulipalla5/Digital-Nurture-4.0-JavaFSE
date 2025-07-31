import React, { useState } from 'react';

function Counter() {
  const [count, setCount] = useState(0);

  const increment = () => {
    setCount(count + 1);
    sayHello();
  };

  const decrement = () => {
    setCount(count - 1);
  };

  const sayHello = () => {
    console.log("Hello! Counter increased.");
  };

  return (
    <div>
      <h2>Counter: {count}</h2>
      <button onClick={increment}>Increment</button>
      <button onClick={decrement} style={{ marginLeft: "10px" }}>Decrement</button>
    </div>
  );
}

export default Counter;
