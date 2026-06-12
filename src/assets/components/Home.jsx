import { useNavigate } from "react-router-dom";

export default function Home() {
  const navigate = useNavigate();

  return (
    <div className="hero">

      <h1>Welcome to ParkIQ</h1>
      <p>Smart Parking Slot Booking System</p>

      <button
        className="hero-btn"
        onClick={() => navigate("/login")}
      >
        Book Your Slot Now
      </button>
    </div>
  );
}