package com.acciojob.LibraryManagementSystem.Controller;


import com.acciojob.LibraryManagementSystem.Model.Transaction;
import com.acciojob.LibraryManagementSystem.Repository.TransactionRepository;
import com.acciojob.LibraryManagementSystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PutMapping("/bookIssued")
    public ResponseEntity bookIssued(@RequestParam("bookId") Integer bookId,
                                     @RequestParam("cardId") Integer cardId) {

        try {
            String result = transactionService.bookIssued(bookId, cardId);
            return new ResponseEntity(result, HttpStatus.OK);

        }catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
