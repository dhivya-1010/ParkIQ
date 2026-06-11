package com.project.parkIQ.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookingStatus;

    @ManyToOne
    private User user;

    @ManyToOne
    private ParkingSlot parkingSlot;
}
