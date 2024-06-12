package com.acciojob.LibraryManagementSystem.Repository;

import com.acciojob.LibraryManagementSystem.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
