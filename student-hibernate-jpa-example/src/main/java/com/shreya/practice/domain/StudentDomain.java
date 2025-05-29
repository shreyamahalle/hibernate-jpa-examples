package com.shreya.practice.domain;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "STUDENT")
//@EntityListeners(Auditing)
public class StudentDomain {

    @Id
    @ToString.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    int id;
    @Column(name = "NAME")
    String name;
    @Column(name = "PERCENTAGE")
    double percentage;
}