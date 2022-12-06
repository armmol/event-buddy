package com.accenture.eventbuddy.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long visitorId;
    private String visitorName;
    private String visitorSurname;
    private String visitorEMail;
    private Gender gender;
    private Date dateOfBirth;
    private String visitorDescription;

    @ManyToOne(targetEntity = Language.class, cascade = CascadeType.ALL)
    private Language language;





}