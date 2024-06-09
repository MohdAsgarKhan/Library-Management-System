package com.acciojob.LibraryManagementSystem.Repository;

import com.acciojob.LibraryManagementSystem.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
