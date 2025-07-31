import React from 'react';

const books = [
  { id: 1, title: 'The Alchemist', author: 'Paulo Coelho' },
  { id: 2, title: 'Rich Dad Poor Dad', author: 'Robert Kiyosaki' },
  { id: 3, title: 'Atomic Habits', author: 'James Clear' }
];

function BookDetails() {
  return (
    <div>
      <h2>📘 Book List</h2>
      <ul>
        {books.map((book) => (
          <li key={book.id}>
            <b>{book.title}</b> by {book.author}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default BookDetails;
