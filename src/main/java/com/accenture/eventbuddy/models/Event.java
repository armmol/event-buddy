package com.accenture.eventbuddy.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;


@Entity
@Data
public class Event{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eventId;
    private String name;
    private Date startDate;
    private Date endDate;
    private String description;
    private Genre genre;

    @ManyToOne(targetEntity = Organizer.class, cascade = CascadeType.ALL)
    private Organizer organizer;

    @ManyToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
    private Address address;

}