package com.acciojob.LibraryManagementSystem.Service;

import com.acciojob.LibraryManagementSystem.Model.Author;
import com.acciojob.LibraryManagementSystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public String addAuthor(Author author) {

        authorRepository.save(author);

        return "The author has been saved to the DB with AuthorId";
    }

    public Author findAuthorById(Integer authorId) throws Exception{

        Optional<Author> optionalAuthor = authorRepository.findById(authorId);

        if(optionalAuthor.isEmpty()) {
           throw new Exception("invalid author id is entered! ");
        }
        Author author = optionalAuthor.get();

        return author;
    }
}
