package com.project.parkIQ.service;

import com.project.parkIQ.Repository.BookingRepository;
import com.project.parkIQ.Repository.ParkingSlotRepo;
import com.project.parkIQ.entity.Booking;
import com.project.parkIQ.entity.ParkingSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ParkingSlotRepo parkingSlotRepo;

    public Booking bookSlot(Long slotId){
        ParkingSlot slot = parkingSlotRepo.findById(slotId).orElseThrow(() -> new RuntimeException("Slot not found"));

        if (!"AVAILABLE".equalsIgnoreCase(slot.getStatus())) {
            throw new RuntimeException("Slot already occupied");
        }

        slot.setStatus("OCCUPIED");
        parkingSlotRepo.save(slot);

        Booking booking = new Booking();
        booking.setParkingSlot(slot);
        booking.setBookingStatus("ACTIVE");

        return bookingRepository.save(booking);
    }
    public Booking cancelBooking(Long bookingId){

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        ParkingSlot slot = booking.getParkingSlot();

        slot.setStatus("AVAILABLE");
        parkingSlotRepo.save(slot);

        booking.setBookingStatus("CANCELLED");

        return bookingRepository.save(booking);
    }
}
