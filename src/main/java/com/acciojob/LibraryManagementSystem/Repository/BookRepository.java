package com.acciojob.LibraryManagementSystem.Repository;

import com.acciojob.LibraryManagementSystem.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
