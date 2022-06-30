package com.example.CourseBooking.controllers;

import com.example.CourseBooking.models.Course;
import com.example.CourseBooking.repositories.CourseRepository;
import com.example.CourseBooking.repositories.CustomerRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value="/courses/rates/{rate}")
    public ResponseEntity<List<Course>> getRatings(@PathVariable int rate){
        return new ResponseEntity<>(courseRepository.findByRate(rate), HttpStatus.OK);
    }

    @GetMapping(value="/courses/customers/{name}")
    public ResponseEntity<List<Course>> getRatings(@PathVariable String name){
        return new ResponseEntity<>(courseRepository.findByCustomers_Name(name), HttpStatus.OK);
    }


}
