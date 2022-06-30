package com.example.CourseBooking.repositories;

import com.example.CourseBooking.models.Course;
import com.example.CourseBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select c from Customer c where c.course.name = ?1")
    List<Customer> findByCourse_Name(String name);

    @Query("select c from Customer c where c.age > ?1 and c.course.town = ?2")
    List<Customer> findByAgeGreaterThanAndCourse_Town(int age, String town);




}
