package com.accenture.eventbuddy.models;

import jakarta.persistence.*;
import lombok.Data;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
    private List<Attendance> attendances = new ArrayList<>();

    public List<Attendance> getAttendances() {
        return attendances;
    }
    public void setAttendances(List<Attendance> attendances){ this.attendances = attendances;}




}