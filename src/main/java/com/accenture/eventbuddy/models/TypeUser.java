package com.accenture.eventbuddy.models;

import com.accenture.eventbuddy.auth.User;
import com.accenture.eventbuddy.auth.UserRole;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

@Data
public class TypeUser {
    Visitor visitor = new Visitor();
    Organizer organizer = new Organizer();
    String username;
    String password;
    UserRole role;
    String name;
    String surname;
    String email;
    Gender gender;
    Language language;
    String dateOfBirth;
    String description;
    String phoneNumber;

    public Organizer isOrganizer() {
        User user = new User();
        user.setRole(role);
        user.setPassword(password);
        user.setUsername(username);
        organizer.setUser(user);
        organizer.setOrganizerEmail(email);
        organizer.setOrganizerName(name);
        organizer.setPhoneNumber(phoneNumber);
        return organizer;
    }

    public Visitor isVisitor() {
        User user = new User();
        user.setRole(role);
        user.setPassword(password);
        user.setUsername(username);
        visitor.setUser(user);
        visitor.setVisitorEmail(email);
        visitor.setVisitorName(name);
        visitor.setVisitorDescription(description);//null
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            visitor.setDateOfBirth(formatter.parse(dateOfBirth));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        visitor.setVisitorSurname(surname);
        visitor.setGender(gender);
        visitor.setVisitorLanguage(language);
        return this.visitor;
    }
}
