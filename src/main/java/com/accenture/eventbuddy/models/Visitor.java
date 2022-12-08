package com.accenture.eventbuddy.models;

import com.accenture.eventbuddy.auth.User;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@Entity
@Data
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long visitorId;
    private String visitorName;
    private String visitorSurname;
    private String visitorEmail;
    private Gender gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String visitorDescription;
    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    private User user;

    @ManyToOne(targetEntity = Language.class, cascade = CascadeType.ALL)
    private Language language;
}