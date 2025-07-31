import React from 'react';

function App() {
  const officeList = [
    {
      name: 'T-Hub Hyderabad',
      rent: 45000,
      address: 'Gachibowli, Hyderabad',
      image: 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/37/T-Hub_Building.jpg/800px-T-Hub_Building.jpg'
    },
    {
      name: 'WeWork BKC',
      rent: 75000,
      address: 'Bandra Kurla Complex, Mumbai',
      image: 'https://assets.wework.com/v3/images/hero/Wework-India-BKC-4.width-800.jpg'
    },
    {
      name: 'IndiQube Alpha',
      rent: 58000,
      address: 'Outer Ring Road, Bengaluru',
      image: 'https://www.indiqube.com/wp-content/uploads/2020/05/IndiQube-Alpha.jpg'
    }
  ];

  const title = <h1 style={{ textAlign: 'center', color: '#2c3e50' }}>🏢 Office Space Rental App</h1>;

  return (
    <div style={{ padding: '20px' }}>
      {title}
      {officeList.map((office, index) => (
        <div
          key={index}
          style={{
            border: '1px solid #ccc',
            borderRadius: '10px',
            padding: '20px',
            margin: '20px auto',
            width: '80%',
            boxShadow: '0 4px 8px rgba(0,0,0,0.1)'
          }}
        >
          <img
            src={office.image}
            alt={office.name}
            style={{ width: '100%', height: '300px', objectFit: 'cover', borderRadius: '10px' }}
          />
          <h2 style={{ marginTop: '10px' }}>{office.name}</h2>
          <p><b>Address:</b> {office.address}</p>
          <p>
            <b>Rent:</b>{' '}
            <span style={{ color: office.rent > 60000 ? 'green' : 'red' }}>
              ₹{office.rent}
            </span>
          </p>
        </div>
      ))}
    </div>
  );
}

export default App;
