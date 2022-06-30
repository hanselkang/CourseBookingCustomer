package com.example.CourseBooking.controllers;

import com.example.CourseBooking.models.Booking;
import com.example.CourseBooking.models.Course;
import com.example.CourseBooking.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value="/booking/{date}")
    public ResponseEntity<List<Booking>> getBookingsByDate(@PathVariable String date){
        return new ResponseEntity<>(bookingRepository.findByDate(date), HttpStatus.OK);
    }

}
