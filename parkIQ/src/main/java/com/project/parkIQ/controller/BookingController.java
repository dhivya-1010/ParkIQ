package com.project.parkIQ.controller;

import com.project.parkIQ.entity.Booking;
import com.project.parkIQ.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/{slotId}")
    public Booking bookSlot(@PathVariable Long slotId){
        return bookingService.bookSlot(slotId);
    }
    @DeleteMapping("/{bookingId}")
    public Booking cancelBooking(@PathVariable Long bookingId){
        return bookingService.cancelBooking(bookingId);
    }
}
