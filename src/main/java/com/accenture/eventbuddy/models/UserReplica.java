package com.accenture.eventbuddy.models;

import com.accenture.eventbuddy.auth.UserRole;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity(name = "user_table")
@Data
public class UserReplica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "USERNAME")
    String username;
    @Column(name = "PASSWORD")
    String password;
    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    UserRole role;
    @Column(name = "NAME")
    String name;
    @Column(name = "SURNAME")
    String surname;
    @Column(name = "EMAIL")
    String email;
    @Column(name = "GENDER")
    @Enumerated(EnumType.STRING)
    Gender gender;
    @Column(name = "LANGUAGES")
    @Enumerated(EnumType.STRING)
    Language languages;
    @Column(name = "DATE_OF_BIRTH")
    Date dateOfBirth;
    @Column(name = "DESCRIPTION")
    String description;
    @Column(name = "PHONE_NUMBER")
    String phoneNumber;
    @OneToMany(targetEntity = Event.class, fetch = FetchType.EAGER, mappedBy = "eventId")
    private List<Event> events = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserReplica that)) return false;
        return username.equals(that.username) && password.equals(that.password) && role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, role);
    }
    public int getAge() {
        Date date = new Date();
        int age = date.getYear() - dateOfBirth.getYear();
        if (date.getYear() < dateOfBirth.getMonth() || date.getMonth() == dateOfBirth.getMonth() && date.getDate() < dateOfBirth.getDate()) {
            age--;
        }
        return age;
    }
}