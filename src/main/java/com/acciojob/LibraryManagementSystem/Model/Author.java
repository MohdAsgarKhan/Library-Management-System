package com.acciojob.LibraryManagementSystem.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "author_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Author {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;

    private String authorName;

    private Integer noOfBooks;

    private Double rating;

    private String emailId;
}
