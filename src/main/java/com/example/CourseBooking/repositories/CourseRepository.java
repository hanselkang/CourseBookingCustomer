package com.example.CourseBooking.repositories;

import com.example.CourseBooking.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {
    @Query("select c from Course c where c.rate = ?1")
    List<Course> findByRate(int rate);

    @Query("select c from Course c inner join c.customers customers where customers.name = ?1")
    List<Course> findByCustomers_Name(String name);



}
