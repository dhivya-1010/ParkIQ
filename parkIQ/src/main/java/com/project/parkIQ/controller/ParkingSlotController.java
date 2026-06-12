package com.project.parkIQ.controller;

import com.project.parkIQ.entity.ParkingSlot;
import com.project.parkIQ.service.ParkingSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

//@CrossOrigin("*")
public class ParkingSlotController {

    @Autowired
    ParkingSlotService parkingSlotService;

    // Add Parking Slot
    @PostMapping("/api/slots")
    public ResponseEntity<ParkingSlot> addSlot(
            @RequestBody ParkingSlot slot) {

        ParkingSlot savedSlot =
                parkingSlotService.addSlot(slot);

        return ResponseEntity.ok(savedSlot);
    }

    // Get All Parking Slots
    @GetMapping("/api/slots")
    public ResponseEntity<List<ParkingSlot>> getAllSlots() {

        return ResponseEntity.ok(
                parkingSlotService.getAllSlots());
    }

    // Get Parking Slot By ID
    @GetMapping("/api/slots/{id}")
    public ResponseEntity<ParkingSlot> getSlotById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                parkingSlotService.getSlotById(id));
    }

    // Update Parking Slot
    @PutMapping("/api/slots/{id}")
    public ResponseEntity<ParkingSlot> updateSlot(
            @PathVariable Long id,
            @RequestBody ParkingSlot slot) {

        return ResponseEntity.ok(
                parkingSlotService.updateSlot(id, slot));
    }

    // Delete Parking Slot
    @DeleteMapping("/api/slots/{id}")
    public ResponseEntity<String> deleteSlot(
            @PathVariable Long id) {

        parkingSlotService.deleteSlot(id);

        return ResponseEntity.ok(
                "Parking slot deleted successfully");
    }

    // Get Available Slots
    @GetMapping("/api/slots/available")
    public ResponseEntity<List<ParkingSlot>> getAvailableSlots() {

        return ResponseEntity.ok(
                parkingSlotService.getAvailableSlots());
    }
}