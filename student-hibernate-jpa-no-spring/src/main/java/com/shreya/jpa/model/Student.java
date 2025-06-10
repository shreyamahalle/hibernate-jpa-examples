package com.shreya.jpa.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String course;

    // Getters and setters
}
