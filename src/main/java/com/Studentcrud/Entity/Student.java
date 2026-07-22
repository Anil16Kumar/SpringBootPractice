package com.Studentcrud.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long studentId;

    @Column(nullable = false)
    String studentName;

    @Column(nullable = false)
    String course;

    @Column(nullable = false)
    Double courseFee;
}
