package com.accenture.eventbuddy.models;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;


@Entity
@Data
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attendanceId;
    private Date attendanceDate;

    @ManyToOne(targetEntity = Event.class, cascade = CascadeType.ALL)
    private Event event;
}

