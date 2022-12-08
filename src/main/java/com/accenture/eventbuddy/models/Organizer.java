package com.accenture.eventbuddy.models;

import com.accenture.eventbuddy.auth.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long organizerId;
    private String organizerName;
    private String organizerEmail;
    private String phoneNumber;
    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    private User user;



}