package com.shreya.practice.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Student {
    int id;
    String name;
    double percentage;
}
