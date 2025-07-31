import React from 'react';

export default function OddPlayers({ players }) {
  const odd = players.filter((_, i) => i % 2 === 0);

  return (
    <div>
      <h2>Odd Indexed Players</h2>
      <ul>
        {odd.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
}