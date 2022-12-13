package com.accenture.eventbuddy.models;

import jakarta.persistence.*;
import lombok.Data;


@Entity(name="attendance_table")
@Data
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attendanceId;
   // @DateTimeFormat(pattern = "yyyy-MM-dd")
  //  private Date attendanceDate;
    @JoinColumn(name="event_col")
    @ManyToOne(targetEntity = Event.class, cascade = CascadeType.ALL)
    private Event event;
    @JoinColumn(name="visit_col")
    @ManyToOne(targetEntity = Visitor.class, cascade = CascadeType.ALL)
    private Visitor visitor;


}

