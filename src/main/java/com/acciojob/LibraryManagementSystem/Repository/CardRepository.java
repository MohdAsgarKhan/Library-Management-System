package com.acciojob.LibraryManagementSystem.Repository;

import com.acciojob.LibraryManagementSystem.Model.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<LibraryCard, Integer> {
}
