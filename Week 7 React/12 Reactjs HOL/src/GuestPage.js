import React from 'react';

function GuestPage() {
  return (
    <div>
      <h2>Welcome Guest!</h2>
      <p>You can view flights, but must login to book tickets.</p>
      <ul>
        <li>Delhi → Mumbai</li>
        <li>Bengaluru → Chennai</li>
        <li>Kolkata → Hyderabad</li>
      </ul>
    </div>
  );
}

export default GuestPage;
