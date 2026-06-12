export default function SlotCard(props) {
  return (
    <div
      className={`slot ${
        props.status === "Available"
          ? "available"
          : "booked"
      }`}
    >
      <h3>{props.id}</h3>
      <p>{props.status}</p>
      {props.vehicle && (
        <h4>{props.vehicle}</h4>
      )}
    </div>
  );
}