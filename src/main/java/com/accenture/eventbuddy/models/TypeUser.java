package com.accenture.eventbuddy.models;

import com.accenture.eventbuddy.auth.UserRole;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

@Data
public class TypeUser {
//    Visitor visitor = new Visitor();
//    Organizer organizer = new Organizer();
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

    public UserReplica isUserReplica() {
        UserReplica user = new UserReplica();
        user.setRole(role);
        user.setPassword(password);
        user.setUsername(username);
        user.setEmail(email);
        user.setName(name);
        user.setSurname(surname);
        user.setPhoneNumber(phoneNumber);
        user.setGender(gender);
        user.setLanguages(language);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            user.setDateOfBirth(formatter.parse(dateOfBirth));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

//    public Visitor isVisitor() {
//        User user = new User();
//        user.setRole(role);
//        user.setPassword(password);
//        user.setUsername(username);
//        visitor.setUser(user);
//        visitor.setVisitorEmail(email);
//        visitor.setVisitorName(name);
//        visitor.setVisitorDescription(description);//null
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
//        try {
//            visitor.setDateOfBirth(formatter.parse(dateOfBirth));
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//        visitor.setVisitorSurname(surname);
//        visitor.setGender(gender);
//        visitor.setVisitorLanguage(language);
//        return this.visitor;
//    }


}
