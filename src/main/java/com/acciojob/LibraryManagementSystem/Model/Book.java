package com.acciojob.LibraryManagementSystem.Model;

import com.acciojob.LibraryManagementSystem.Enum.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity  //Representation of actual table
@Table  //this is annotation of Spring Data JPA dependency
@Getter  //all below annotation of lombok dependency
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    private String bookName;
    private Integer noOfPages;

    private Boolean isBookIssued;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    //between author and book table book is child class so we have foreign key in this table

    @JoinColumn
    @ManyToOne //we are writing in this child class so mapping will be according to child class many books have one author
    private Author author;

}
