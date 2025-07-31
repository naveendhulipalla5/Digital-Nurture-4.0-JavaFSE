import React, { useState } from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

function App() {
  const [selected, setSelected] = useState('book');

  const renderSection = () => {
    // 1. if-else method
    if (selected === 'book') return <BookDetails />;
    else if (selected === 'blog') return <BlogDetails />;
    else if (selected === 'course') return <CourseDetails />;
    else return null;
  };

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>📚 Blogger App</h1>

      {/* 2. buttons to choose section */}
      <div>
        <button onClick={() => setSelected('book')}>Book Details</button>
        <button onClick={() => setSelected('blog')}>Blog Details</button>
        <button onClick={() => setSelected('course')}>Course Details</button>
      </div>

      <hr />

      {/* 3. Conditional Rendering using function */}
      {renderSection()}
    </div>
  );
}

export default App;
