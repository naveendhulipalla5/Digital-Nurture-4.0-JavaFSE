import React from 'react';

const courses = [
  { id: 'C1', name: 'React', duration: '4 weeks' },
  { id: 'C2', name: 'Node.js', duration: '3 weeks' },
  { id: 'C3', name: 'MongoDB', duration: '2 weeks' }
];

function CourseDetails() {
  return (
    <div>
      <h2>📚 Course Details</h2>
      <table border="1" cellPadding="10">
        <thead>
          <tr>
            <th>Name</th>
            <th>Duration</th>
          </tr>
        </thead>
        <tbody>
          {courses.map((course) => (
            <tr key={course.id}>
              <td>{course.name}</td>
              <td>{course.duration}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default CourseDetails;
