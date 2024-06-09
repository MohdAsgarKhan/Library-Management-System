package com.acciojob.LibraryManagementSystem.Controller;

import com.acciojob.LibraryManagementSystem.Repository.CardRepository;
import com.acciojob.LibraryManagementSystem.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("add")
    public String addCard() {

        return cardService.addNewCard();
    }

    @PutMapping("associateCardAndStudent")

    public String associateCardAndStudent(@RequestParam("CardId") Integer cardId, @RequestParam("StudentId") Integer studentId) {

        return cardService.associateCardAndStudent(cardId, studentId);
    }

}
