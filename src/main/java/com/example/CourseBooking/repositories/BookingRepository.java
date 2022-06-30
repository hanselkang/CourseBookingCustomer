package com.example.CourseBooking.repositories;

import com.example.CourseBooking.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("select b from Booking b where b.date = ?1")
    List<Booking> findByDate(String date);



}
