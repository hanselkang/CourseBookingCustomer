package com.example.CourseBooking.controllers;

import com.example.CourseBooking.models.Course;
import com.example.CourseBooking.models.Customer;
import com.example.CourseBooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/customers/{course}")
    public ResponseEntity<List<Customer>> getCourseByName(@PathVariable String course){
        return new ResponseEntity<>(customerRepository.findByCourse_Name(course), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/find")
    public ResponseEntity<List<Customer>> getCustomersByTownAndCourse(
            @RequestParam(required = false, name = "course_name") String courseName
    ){
        return new ResponseEntity(customerRepository.findByCourse_Name(courseName), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/age")
    public ResponseEntity<List<Customer>> getCustomersOverAgeInTownOfCourse(
            @RequestParam(required = false, name = "age") int age,
            @RequestParam(required = false, name = "town") String town
    ){
        return new ResponseEntity(customerRepository.findByAgeGreaterThanAndCourse_Town(age, town), HttpStatus.OK);
    }


//    findByAgeGreaterThanAndCourse_Town(int age, String town)
//    findByTownAndCourse_Name(String town, String name)



}
