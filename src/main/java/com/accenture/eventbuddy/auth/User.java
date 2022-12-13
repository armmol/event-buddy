package com.accenture.eventbuddy.auth;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "user_table")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    @Enumerated(EnumType.STRING)
    UserRole role;

}
