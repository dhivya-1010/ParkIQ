import { useState } from "react";
import { useNavigate } from "react-router-dom";

export default function SlotBooking({
  slots,
  setSlots,
}) {

  const navigate = useNavigate();

  const [slot, setSlot] = useState("");
  const [vehicle, setVehicle] = useState("");

  const handleBooking = () => {

    if (!slot || !vehicle) {
      alert("Fill all fields");
      return;
    }

    const updatedSlots = slots.map((s) =>
      s.id === slot
        ? {
             ...s,
             status: "Booked",
             vehicle: vehicle,
           }
            : s
    );

    setSlots(updatedSlots);

    alert(`Slot ${slot} booked successfully`);

    navigate("/dashboard");
  };

  return (
    <div className="container">

      <h2>BOOK SLOT</h2>

      <select
        value={slot}
        onChange={(e) => setSlot(e.target.value)}
      >
        <option value="">
          Select Slot
        </option>

        {slots
          .filter((s) => s.status === "Available")
          .map((s) => (
            <option key={s.id} value={s.id}>
              {s.id}
            </option>
          ))}
      </select>

      <input
        type="text"
        placeholder="Vehicle Number"
        value={vehicle}
        onChange={(e) => setVehicle(e.target.value)}
      />

      <button onClick={handleBooking}>
        Confirm Booking
      </button>

    </div>
  );
}