import SlotCard from "./SlotCard";
import { useNavigate } from "react-router-dom";

export default function Dashboard({ slots }) {
  const navigate = useNavigate();

  return (
    <div className="container">
      <h2>DASHBOARD</h2>

      <div className="slot-container">
        {slots.map((slot) => (
          <SlotCard
            key={slot.id}
            id={slot.id}
            status={slot.status}
            vehicle={slot.vehicle}
          />
        ))}

      </div>

      <button
        onClick={() => navigate("/book-slot")}
      >
        Go To Book Slot
      </button>
    </div>
  );
}