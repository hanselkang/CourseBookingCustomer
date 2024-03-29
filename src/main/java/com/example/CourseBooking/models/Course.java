package com.example.CourseBooking.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="town")
    private String town;
    @Column(name="rate")
    private int rate;

    @JsonBackReference
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<Customer> customers;

    @JsonBackReference
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<Booking> bookings;


    public Course(String name, String town, int rate) {
        this.name = name;
        this.town = town;
        this.rate = rate;
        this.customers = new ArrayList<>();
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Course() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
