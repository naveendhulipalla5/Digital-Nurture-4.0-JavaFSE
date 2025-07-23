// src/Posts.js
import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
    };
  }

  loadPosts = () => {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then((res) => res.json())
      .then((data) => {
        const postList = data.map(post => new Post(post.id, post.title, post.body));
        this.setState({ posts: postList });
      })
      .catch((error) => {
        console.error('Error fetching posts:', error);
        throw error;  // Triggers componentDidCatch if there's an error
      });
  };

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, info) {
    alert('An error occurred while rendering: ' + error.message);
    console.error("Error info:", info);
  }

  render() {
    return (
      <div>
        <h1>Post List</h1>
        {this.state.posts.map((post) => (
          <div key={post.id}>
            <h2>{post.title}</h2>
            <p>{post.body}</p>
            <hr />
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
