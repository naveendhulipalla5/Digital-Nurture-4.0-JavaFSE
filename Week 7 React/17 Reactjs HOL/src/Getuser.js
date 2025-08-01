import React, { Component } from 'react';

class Getuser extends Component {
  constructor() {
    super();
    this.state = {
      user: null,
    };
  }

  // Fetch user from API when component mounts
  async componentDidMount() {
    try {
      const res = await fetch('https://api.randomuser.me/');
      const data = await res.json();
      this.setState({ user: data.results[0] });
    } catch (error) {
      console.error('Failed to fetch user:', error);
    }
  }

  render() {
    const { user } = this.state;

    if (!user) {
      return <p>Loading user...</p>;
    }

    return (
      <div>
        <h3>User Details</h3>
        <p>
          <strong>Name:</strong> {user.name.title} {user.name.first}
        </p>
        <img src={user.picture.large} alt="User" style={{ borderRadius: '8px' }} />
      </div>
    );
  }
}

export default Getuser;
