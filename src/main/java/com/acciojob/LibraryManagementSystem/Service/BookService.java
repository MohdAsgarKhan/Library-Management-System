package com.acciojob.LibraryManagementSystem.Service;

import com.acciojob.LibraryManagementSystem.Enum.CardStatus;
import com.acciojob.LibraryManagementSystem.Enum.Genre;
import com.acciojob.LibraryManagementSystem.Model.Author;
import com.acciojob.LibraryManagementSystem.Model.Book;
import com.acciojob.LibraryManagementSystem.Model.LibraryCard;
import com.acciojob.LibraryManagementSystem.Repository.AuthorRepository;
import com.acciojob.LibraryManagementSystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public String addBook(Book book) {
        bookRepository.save(book);

        return "The Book details has been saved to the DB! ";
    }

    public String associateBookAndAuthor(Integer bookId, Integer authorId) throws Exception {

        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if(optionalBook.isEmpty()) {
            throw new Exception("Entered BookID is invalid! ");
        }

        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        if(optionalAuthor.isEmpty()) {
            throw new Exception("Entered AuthorID is invalid! ");
        }

        Book book = optionalBook.get();
        Author author = optionalAuthor.get();

        //Book is child class hence setting up FOREIGN KEY
        book.setAuthor(author);  //FOREIGN KEY set...with author entity.

        author.setNoOfBooks(author.getNoOfBooks()+1);

        bookRepository.save(book);
        authorRepository.save(author);

        return "Book and Author entity have been associated";
    }
}
