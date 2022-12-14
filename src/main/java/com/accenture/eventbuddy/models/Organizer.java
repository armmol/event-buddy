package com.accenture.eventbuddy.models;

import com.accenture.eventbuddy.auth.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(targetEntity = Event.class, fetch = FetchType.EAGER, mappedBy = "eventId")
    private List<Event> events = new ArrayList<>();
    public List<Event> getEvent() {
        return events;
    }
    public void setEvent(List<Event> events){ this.events = events;}

}