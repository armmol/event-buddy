package com.accenture.eventbuddy.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity (name="match_table")
@Data
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchId;
    @JoinColumn(name="att1_col")
    @ManyToOne(targetEntity = Attendance.class, cascade = CascadeType.ALL)
    private Attendance attendance1;
    @JoinColumn(name="att2_col")
    @ManyToOne(targetEntity = Attendance.class, cascade = CascadeType.ALL)
    private Attendance attendance2;

}
