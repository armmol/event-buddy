package com.accenture.eventbuddy.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class FilterAttendanceFormData {
    private Language language;
    private Gender gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
}
