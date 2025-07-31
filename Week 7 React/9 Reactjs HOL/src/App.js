import React from 'react';
import ListofPlayers from './ComponentsTEMP/ListofPlayers';
import Scorebelow70 from './ComponentsTEMP/Scorebelow70';
import OddPlayers from './ComponentsTEMP/OddPlayers';
import EvenPlayers from './ComponentsTEMP/EvenPlayers';
import IndianPlayers from './ComponentsTEMP/ListofIndianPlayers';

function App() {
  const players = ["Virat", "Rohit", "Rahul", "Dhoni", "Shreyas", "Gill"];
  const scores = [75, 65, 82, 70, 55, 90];
  const odd = players.filter((_, i) => i % 2 === 0);
  const even = players.filter((_, i) => i % 2 === 1);

  const flag = false; // Change to false to view Indian players section

  return (
    <div>
      <h1>Cricket App</h1>
      {flag ? (
        <>
          <ListofPlayers players={players} />
          <Scorebelow70 players={players} scores={scores} />
        </>
      ) : (
        <>
          <OddPlayers players={players} />
          <EvenPlayers players={players} />
          <IndianPlayers odd={odd} even={even} />
        </>
      )}
    </div>
  );
}

export default App;