import { Link } from "react-router-dom";

export default function Navbar() {
  return (
    <nav className="navbar">

      <h2>ParkIQ</h2>

      <div>
        <Link to="/">Home</Link>{" | "}
        <Link to="/login">Login</Link>{" | "}
        <Link to="/dashboard">Dashboard</Link>{" | "}
        <Link to="/book-slot">Book Slot</Link>
      </div>

    </nav>
  );
}