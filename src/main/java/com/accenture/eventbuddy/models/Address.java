package com.accenture.eventbuddy.models;

import jakarta.persistence.*;
import lombok.Data;


@Entity (name="address_table")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String country;
    private String city;
    //@OneToMany(targetEntity = Event.class)
   // private Event event;

}