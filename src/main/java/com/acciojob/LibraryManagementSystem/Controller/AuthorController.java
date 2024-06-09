package com.acciojob.LibraryManagementSystem.Controller;

import com.acciojob.LibraryManagementSystem.Model.Author;
import com.acciojob.LibraryManagementSystem.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author")

public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("add")
    public String addAuthor(@RequestBody Author author) {

        return authorService.addAuthor(author);
    }

    @GetMapping("findAuthorById")

    public ResponseEntity findAuthorById(@RequestParam("id") Integer authorId){

        //the benefit of using Response entity is that we are returning integer and string both when we find authorid
        //we are returning integer when not we are returning String as-"Invalid authorId entered"
        //if we dont use this we always return only one datatype

        try {

            Author authorResponse = authorService.findAuthorById(authorId);

            return new ResponseEntity(authorResponse, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }
}
