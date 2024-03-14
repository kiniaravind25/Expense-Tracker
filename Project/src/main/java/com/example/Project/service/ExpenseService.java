package com.example.Project.service;

import com.example.Project.entity.Expense;
import com.example.Project.repository.ExpenseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense saveExpense(Expense expense) {

        if (expense.getAmount() <= 0) {
            log.error("Invalid Input");
            throw new IllegalArgumentException("Amount should be greater than 0");

        }
        return expenseRepository.save(expense);
    }

    public List<Expense> saveTheList(List<Expense> expense) {
        return expenseRepository.saveAll(expense);
    }

    public List<Expense> getAllProducts() {
        return expenseRepository.findAll();
    }

    public Expense findById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    public Expense findByCat(String category) {
        return expenseRepository.findByCategory(category);
    }

    public Expense update(Expense expenses) {
        Expense expense = expenseRepository.findById(expenses.getId()).orElse(null);

        expense.setAmount(expenses.getAmount());
        expense.setCategory(expenses.getCategory());
        expense.setDescription(expenses.getDescription());
        expense.setDate(expenses.getDate());

        return expenseRepository.save(expense);
    }

    public String deleteId(Long id) {
        expenseRepository.deleteById(id);
        return "deleted";
    }
}
