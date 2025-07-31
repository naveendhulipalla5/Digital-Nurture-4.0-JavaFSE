import React from 'react';

function UserPage() {
  return (
    <div>
      <h2>Welcome, User!</h2>
      <p>Book your flight tickets below:</p>
      <ul>
        <li>
          Delhi → Mumbai <button>Book</button>
        </li>
        <li>
          Bengaluru → Chennai <button>Book</button>
        </li>
        <li>
          Kolkata → Hyderabad <button>Book</button>
        </li>
      </ul>
    </div>
  );
}

export default UserPage;
