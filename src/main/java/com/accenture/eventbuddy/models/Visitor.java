package com.accenture.eventbuddy.models;

import com.accenture.eventbuddy.auth.User;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

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
    // get age by date of birth
    public int getAge() {
        Date date = new Date();
        int age = date.getYear() - dateOfBirth.getYear();
        if (date.getMonth() < dateOfBirth.getMonth()) {
            age--;
        } else if (date.getMonth() == dateOfBirth.getMonth() && date.getDate() < dateOfBirth.getDate()) {
            age--;
        }
        return age;
    }
}