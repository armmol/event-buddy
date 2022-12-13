package com.accenture.eventbuddy.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity(name="event_table")
@Data
public class Event{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private String description;
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToOne(targetEntity = Organizer.class, cascade = CascadeType.ALL)
    @JoinColumn(name="org_col")
    private Organizer organizer;

    @ManyToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
    @JoinColumn(name="address_col")
    private Address address;

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
    private List<Attendance> attendances = new ArrayList<>();

    public List<Attendance> getAttendances() {
        return attendances;
    }
    public void setAttendances(List<Attendance> attendances){ this.attendances = attendances;}




}