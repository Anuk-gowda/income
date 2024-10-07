package com.example.expensetracker.controller;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense) {
        return expenseService.createExpense(expense);
    }

    @GetMapping("/total")
    public ResponseEntity<Double> getTotalAmount() {
        return ResponseEntity.ok(expenseService.getTotalAmount());
    }

    @GetMapping("/spend/{date}")
    public ResponseEntity<List<Expense>> getExpensesByDate(@PathVariable String date) {
        return ResponseEntity.ok(expenseService.getExpensesByDate(LocalDate.parse(date)));
    }

    @GetMapping("/monthly/{month}")
    public ResponseEntity<Double> getMonthlyTotal(@PathVariable String month) {
        return ResponseEntity.ok(expenseService.getMonthlyTotal(LocalDate.parse(month)));
    }

    @GetMapping("/balance")
    public ResponseEntity<Double> getCurrentBalance() {
        return ResponseEntity.ok(expenseService.getCurrentBalance());
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }
}
