import React from 'react';

const blogs = [
  { id: 1, title: 'React Basics', author: 'Alice' },
  { id: 2, title: 'Node.js Streams', author: 'Bob' },
  { id: 3, title: 'CSS Grid', author: 'Carol' }
];

function BlogDetails() {
  return (
    <div>
      <h2>📝 Blog Posts</h2>
      {blogs.map((blog) => (
        <div key={blog.id}>
          <h4>{blog.title}</h4>
          <p>Author: {blog.author}</p>
        </div>
      ))}
    </div>
  );
}

export default BlogDetails;
