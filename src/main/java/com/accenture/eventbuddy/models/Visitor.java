package com.accenture.eventbuddy.models;

import com.accenture.eventbuddy.auth.User;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name="visitors_table")
@Data
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long visitorId;
    private String visitorName;
    private String visitorSurname;
    private String visitorEmail;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String visitorDescription;
    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name="user_col")
    private User user;
    @Enumerated(EnumType.STRING)
    private Language visitorLanguage;
    @OneToMany(targetEntity = Attendance.class, fetch = FetchType.EAGER, mappedBy = "attendanceId")
    private List<Attendance> attendances = new ArrayList<>();
    public List<Attendance> getAttendances() {
        return attendances;
    }
    public void setAttendances(List<Attendance> attendances){ this.attendances = attendances;}
}