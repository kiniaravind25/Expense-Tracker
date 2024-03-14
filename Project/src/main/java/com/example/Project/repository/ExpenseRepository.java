package com.example.Project.repository;

import com.example.Project.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{

    Expense findByCategory(String category);
}
