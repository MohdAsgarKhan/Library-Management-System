package com.acciojob.LibraryManagementSystem.Model;

import com.acciojob.LibraryManagementSystem.Enum.CardStatus;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardId;

    private Integer noOfBooksIssued;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    /*
Connect two table parent table is student and child is LibraryCard
    Foreign key should be from child class - To join two column we will written below logic
this should be written in Child Class
*/

    @JoinColumn //Add another column //by default it will add Primary Key incase you want to join any other column just mention name
           //@JoinColumn(refrenecedColumnName = "emailid")
    @OneToOne // Mapping between entries which type of mapping using
    private  Student student; //which entity you are connecting .






}
