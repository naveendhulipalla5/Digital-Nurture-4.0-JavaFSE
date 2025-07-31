import React, { useState } from 'react';
import GuestPage from './GuestPage';
import UserPage from './UserPage';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false); // Step 1: Track login state

  const handleLogin = () => {
    setIsLoggedIn(true); // Step 2: Log in
  };

  const handleLogout = () => {
    setIsLoggedIn(false); // Step 3: Log out
  };

  let page; // Step 4: Element variable for conditional rendering
  if (isLoggedIn) {
    page = <UserPage />;
  } else {
    page = <GuestPage />;
  }

  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <h1>Flight Ticket Booking</h1>

      {/* Step 5: Conditional buttons */}
      {
        isLoggedIn ? 
          <button onClick={handleLogout}>Logout</button> :
          <button onClick={handleLogin}>Login</button>
      }

      <hr />

      {/* Step 6: Render correct page */}
      {page}
    </div>
  );
}

export default App;
