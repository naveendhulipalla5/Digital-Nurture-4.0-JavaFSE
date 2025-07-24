import { useParams } from "react-router-dom";
import { trainers } from "./TrainersMock";

function TrainerDetails() {
  const { id } = useParams();
  const trainer = trainers.find((t) => t.trainerId === parseInt(id));

  return (
    <div>
      <h2>Trainer Details</h2>
      {trainer ? (
        <ul>
          <li><strong>Name:</strong> {trainer.name}</li>
          <li><strong>Email:</strong> {trainer.email}</li>
          <li><strong>Phone:</strong> {trainer.phone}</li>
          <li><strong>Technology:</strong> {trainer.technology}</li>
          <li><strong>Skills:</strong> {trainer.skills.join(", ")}</li>
        </ul>
      ) : (
        <p>Trainer not found.</p>
      )}
    </div>
  );
}

export default TrainerDetails;
