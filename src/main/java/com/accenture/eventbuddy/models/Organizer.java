package com.accenture.eventbuddy.models;

import com.accenture.eventbuddy.auth.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name="organizers_table")
@Data
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long organizerId;
    private String organizerName;
    private String organizerEmail;
    private String phoneNumber;
    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name="user_col")
    private User user;



}