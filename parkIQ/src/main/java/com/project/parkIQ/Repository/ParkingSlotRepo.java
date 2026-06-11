package com.project.parkIQ.Repository;

import com.project.parkIQ.entity.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ParkingSlotRepo extends JpaRepository<ParkingSlot, Long> {
    List<ParkingSlot> findByStatus(String status);
}