package com.example.Project.controller;

import com.example.Project.entity.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Project.service.ExpenseService;

import java.util.List;

@RestController
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;


    @PostMapping("/save")
    public Expense add(@RequestBody Expense expense) {
        return expenseService.saveExpense(expense);
    }

    @PostMapping("/saveAll")
    public List<Expense> addAll(@RequestBody List<Expense> expenseList) {
        return expenseService.saveTheList(expenseList);
    }

    @GetMapping("getAll")
    public List<Expense> findAll() {
        return expenseService.getAllProducts();
    }

    @GetMapping("/findBy/{id}")
    public Expense findById(@PathVariable Long id) {
        return expenseService.findById(id);
    }

    @GetMapping("/find/{category}")
    public Expense findById(@PathVariable String category) {
        return expenseService.findByCat(category);
    }

    @PutMapping("/update")
    public Expense updated(@RequestBody Expense expense) {
        return expenseService.update(expense);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return expenseService.deleteId(id);
    }
}
