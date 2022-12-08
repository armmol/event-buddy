package com.accenture.eventbuddy.auth;

import com.accenture.eventbuddy.models.Organizer;
import com.accenture.eventbuddy.models.Visitor;
import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String password;
    private Visitor visitor = new Visitor();
    private Organizer organizer = new Organizer();
    private UserRole role;
}
