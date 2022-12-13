package com.accenture.eventbuddy.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long matchId;
    @ManyToOne(targetEntity = Attendance.class, cascade = CascadeType.ALL)
    private Attendance attendance1;
    @ManyToOne(targetEntity = Attendance.class, cascade = CascadeType.ALL)
    private Attendance attendance2;

}
