import React, { useState } from 'react';

function ComplaintRegister() {
  const [employeeName, setEmployeeName] = useState('');
  const [complaint, setComplaint] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!employeeName || !complaint) {
      alert('Please fill in all fields.');
      return;
    }

    const referenceNumber = 'REF' + Math.floor(100000 + Math.random() * 900000);
    alert(
      `Complaint Submitted!\nEmployee: ${employeeName}\nComplaint: ${complaint}\nReference Number: ${referenceNumber}`
    );

    setEmployeeName('');
    setComplaint('');
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Employee Name:</label><br />
        <input
          type="text"
          value={employeeName}
          onChange={(e) => setEmployeeName(e.target.value)}
          placeholder="Enter your name"
        />
      </div>
      <br />
      <div>
        <label>Complaint:</label><br />
        <textarea
          rows="4"
          value={complaint}
          onChange={(e) => setComplaint(e.target.value)}
          placeholder="Describe your issue"
        />
      </div>
      <br />
      <button type="submit">Submit Complaint</button>
    </form>
  );
}

export default ComplaintRegister;
