package com.example.Project.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepo extends JpaRepository<Expense, Long>{

    Expense findByCategory(String category);
}
