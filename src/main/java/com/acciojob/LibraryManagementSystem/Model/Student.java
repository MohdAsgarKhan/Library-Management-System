package com.acciojob.LibraryManagementSystem.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity //This is description / reflection of table
@Table
@Getter //It is from Lombok dependency --(reduce boiler plate of code)
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Student {

    @Id  //this annotation is used to define primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    private Integer age;
    private String name;
    private String branch;

    @Column(unique = true)
    private String emailID;
    private String address;





}
