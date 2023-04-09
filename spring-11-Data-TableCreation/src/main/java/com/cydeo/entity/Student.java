package com.cydeo.entity;

import com.cydeo.enums.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity     // adds entity (object) as table to Postgres
@Table(name = "students")   // custom table name
public class Student {

    @Id     // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // ^^ primary key auto created by Postgres
    private Long id;

    @Column(name = "studentFirstName")
    private String firstName;
    @Column(name = "studentLastName")
// ^^ can also set custom column name but not common practice

    private String lastName;
    private String email;

    @Column(columnDefinition = "DATE")
    // ^^ sets data TYPE as Date
    private LocalDate birthDate;
    @Column(columnDefinition = "TIME")
    private LocalTime birthTime;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime birthDateTime;

//    @Enumerated(EnumType.ORDINAL)
    // ^^ DEFAULT =       int ^^
    @Enumerated(EnumType.STRING)
    // ^^ sets Enum Type to String
    private Gender gender;

    @Transient      // field will not show up in the Table
    private String city;
}
