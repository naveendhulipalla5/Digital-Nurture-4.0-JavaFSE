import React from 'react';

export default function EvenPlayers({ players }) {
  const even = players.filter((_, i) => i % 2 === 1);

  return (
    <div>
      <h2>Even Indexed Players</h2>
      <ul>
        {even.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
}