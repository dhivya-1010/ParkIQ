package com.project.parkIQ.service;

import com.project.parkIQ.entity.ParkingSlot;
import com.project.parkIQ.Repository.ParkingSlotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSlotService {
    @Autowired
    ParkingSlotRepo parkingSlotRepository;

    public ParkingSlot addSlot(ParkingSlot slot) {
        return parkingSlotRepository.save(slot);
    }

    public List<ParkingSlot> getAllSlots() {
        return parkingSlotRepository.findAll();
    }

    public ParkingSlot getSlotById(Long id) {
        return parkingSlotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Slot not found"));
    }

    public ParkingSlot updateSlot(Long id, ParkingSlot slot) {

        ParkingSlot existingSlot = parkingSlotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Slot not found"));

        existingSlot.setSlotNumber(slot.getSlotNumber());
        existingSlot.setVehicleType(slot.getVehicleType());
        existingSlot.setStatus(slot.getStatus());

        return parkingSlotRepository.save(existingSlot);
    }

    public void deleteSlot(Long id) {
        parkingSlotRepository.deleteById(id);
    }

    public List<ParkingSlot> getAvailableSlots() {
        return parkingSlotRepository.findByStatus("AVAILABLE");
    }
}