import React from 'react';

export default function Scorebelow70({ players, scores }) {
  const filtered = players.filter((_, i) => scores[i] <= 70);

  return (
    <div>
      <h2>Players with Score Below 70</h2>
      <ul>
        {filtered.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
}