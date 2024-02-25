package com.example.Project.service;

import com.example.Project.entity.Expense;
import com.example.Project.entity.ExpenseRepo;
import jakarta.persistence.Id;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.validation.BindValidationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ExpenseService {

    @Autowired
    private ExpenseRepo expenseRepo;

    public Expense saveExpense(Expense expense) {

        if (expense.getAmount() <= 0) {
            log.error("Invalid Input");
            throw new IllegalArgumentException("Amount should be greater than 0");

        }
        return expenseRepo.save(expense);
    }

    public List<Expense> saveTheList(List<Expense> expense) {
        return expenseRepo.saveAll(expense);
    }

    public List<Expense> getAllProducts() {
        return expenseRepo.findAll();
    }

    public Expense findById(Long id) {
        return expenseRepo.findById(id).orElse(null);
    }

    public Expense findByCat(String category) {
        return expenseRepo.findByCategory(category);
    }

    public Expense update(Expense expenses) {
        Expense expense = expenseRepo.findById(expenses.getId()).orElse(null);

        expense.setAmount(expenses.getAmount());
        expense.setCategory(expenses.getCategory());
        expense.setDescription(expenses.getDescription());
        expense.setDate(expenses.getDate());

        return expenseRepo.save(expense);
    }

    public String deleteId(Long id) {
        expenseRepo.deleteById(id);
        return "deleted";
    }
}
