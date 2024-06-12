package com.acciojob.LibraryManagementSystem.Service;

import com.acciojob.LibraryManagementSystem.Enum.TransactionStatus;
import com.acciojob.LibraryManagementSystem.Model.Book;
import com.acciojob.LibraryManagementSystem.Model.LibraryCard;
import com.acciojob.LibraryManagementSystem.Model.Transaction;
import com.acciojob.LibraryManagementSystem.Repository.BookRepository;
import com.acciojob.LibraryManagementSystem.Repository.CardRepository;
import com.acciojob.LibraryManagementSystem.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CardRepository cardRepository;

    public String bookIssued(int bookID, int cardId) throws Exception {

        //1.Get the Book Entity
        Book book = bookRepository.findById(bookID).get();

        //2.Get the Card Entity
        LibraryCard card = cardRepository.findById(cardId).get();

        //3. Get the transaction entity
        Transaction transaction  = new Transaction();

        //3.Failure : if the book issued - isBookIssued
        if(book.getIsBookIssued()) {
            throw new Exception("Book is already issued");
        }

        //4.no of book issued per card has reached the limit
        if(card.getNoOfBooksIssued() == 3) {
            throw new Exception("Card limit has reached");
        }
        //sucess
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);

        //Set Foreign Key Entities(BOOK and CARD)
        transaction.setBook(book);
        transaction.setLibraryCard(card);

        //book issued mark true
        book.setIsBookIssued(true);

        //set card : no of book issued +1
        card.setNoOfBooksIssued(card.getNoOfBooksIssued()+1);

        //save all book card and transaction in repository
        transaction = transactionRepository.save(transaction);

        bookRepository.save(book);
        cardRepository.save(card);

        return "The transaction has been stored to the DB"+transaction.getTransactionID();
    }
}
