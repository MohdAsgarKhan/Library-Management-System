package com.acciojob.LibraryManagementSystem.Service;

import com.acciojob.LibraryManagementSystem.Enum.CardStatus;
import com.acciojob.LibraryManagementSystem.Model.LibraryCard;
import com.acciojob.LibraryManagementSystem.Model.Student;
import com.acciojob.LibraryManagementSystem.Repository.CardRepository;
import com.acciojob.LibraryManagementSystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private StudentRepository studentRepository;


    public String addNewCard(){
        LibraryCard card = new LibraryCard();
        card.setCardStatus(CardStatus.NEW);
        card.setNoOfBooksIssued(0);
        cardRepository.save(card);
        return "The card has been generated with the cardId ";
    }

    public String associateCardAndStudent(Integer cardId,Integer studentId){

        LibraryCard card = cardRepository.findById(cardId).get();
        Student student = studentRepository.findById(studentId).get();
        card.setStudent(student); //This is how you set the FK
        card.setCardStatus(CardStatus.ACTIVE);

        cardRepository.save(card);
        return "Associating card and student with cardId "+cardId +" and studentId "+studentId;

    }

}