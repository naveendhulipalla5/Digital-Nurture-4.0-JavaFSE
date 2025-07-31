import React, { useState } from 'react';

function CurrencyConvertor() {
  const [rupees, setRupees] = useState('');
  const [euro, setEuro] = useState(null);

  const handleSubmit = (e) => {
    e.preventDefault();
    const conversionRate = 0.011; // 1 INR = 0.011 EUR (approx)
    setEuro(rupees * conversionRate);
  };

  return (
    <div>
      <h2>Currency Converter (INR ➡️ EUR)</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="number"
          value={rupees}
          onChange={(e) => setRupees(e.target.value)}
          placeholder="Amount in INR"
        />
        <button type="submit" style={{ marginLeft: "10px" }}>Convert</button>
      </form>
      {euro !== null && <p>Equivalent Euro: €{euro.toFixed(2)}</p>}
    </div>
  );
}

export default CurrencyConvertor;
