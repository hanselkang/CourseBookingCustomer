package com.example.CourseBooking.components;


import com.example.CourseBooking.models.Booking;
import com.example.CourseBooking.models.Course;
import com.example.CourseBooking.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import com.example.CourseBooking.repositories.BookingRepository;
import com.example.CourseBooking.repositories.CourseRepository;
import com.example.CourseBooking.repositories.CustomerRepository;

@Profile("!test")
//@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public  DataLoader(){

    }

    public  void run(ApplicationArguments args) {

        Course course1 = new Course("Sawing","Edinburgh",1);
        courseRepository.save(course1);
        Course course2 = new Course("Swimming","Dalkeith",2);
        courseRepository.save(course2);
        Course course3 = new Course("Drinking","Livingston",5);
        courseRepository.save(course3);

        Customer customer1 = new Customer("Hansel","West Calder",22,course1);
        customerRepository.save(customer1);
        Customer customer2 = new Customer("Derek","Edinburgh",25,course3);
        customerRepository.save(customer2);

        Booking booking1 = new Booking("01-01-23", customer1, course1);
        bookingRepository.save(booking1);
        Booking booking2 = new Booking("02-01-23",customer2, course3);
        bookingRepository.save(booking2);





    }


}
