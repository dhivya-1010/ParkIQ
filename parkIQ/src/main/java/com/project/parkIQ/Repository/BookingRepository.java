package com.project.parkIQ.Repository;

import com.project.parkIQ.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
