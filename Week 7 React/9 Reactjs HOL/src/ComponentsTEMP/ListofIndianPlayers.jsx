import React from 'react';

export default function IndianPlayers({ odd, even }) {
  const merged = [...odd, ...even];

  return (
    <div>
      <h2>List Of Indian Players</h2>
      <ul>
        {merged.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
}