import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { useState, useEffect } from "react";

import Navbar from "./assets/components/Navbar";
import Home from "./assets/components/Home";
import Login from "./assets/components/Login";
import Dashboard from "./assets/components/Dashboard";
import SlotBooking from "./assets/components/SlotBooking";

export default function App() {

  const [slots, setSlots] = useState([]);

  useEffect(() => {
    setSlots([
      { id: "A1", status: "Available" },
      { id: "A2", status: "Available" },
      { id: "A3", status: "Available" },
      { id: "A4", status: "Available" },
      { id: "B1", status: "Available" },
      { id: "B2", status: "Available" },
    ]);
  }, []);

  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />

        <Route
          path="/login"
          element={<Login />}
        />

        <Route
          path="/dashboard"
          element={<Dashboard slots={slots} />}
        />

        <Route
          path="/book-slot"
          element={
            <SlotBooking
              slots={slots}
              setSlots={setSlots}
            />
          }
        />

      </Routes>
    </BrowserRouter>
  );
}