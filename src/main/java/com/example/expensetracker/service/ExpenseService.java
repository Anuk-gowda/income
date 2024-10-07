package com.example.expensetracker.service;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public List<Expense> getExpensesByDate(LocalDate date) {
        return expenseRepository.findByDate(date);
    }

    public double getTotalAmount() {
        return expenseRepository.findAll().stream().mapToDouble(Expense::getAmtSpent).sum();
    }

    public double getMonthlyTotal(LocalDate month) {
        LocalDate startDate = month.withDayOfMonth(1);
        LocalDate endDate = month.withDayOfMonth(month.lengthOfMonth());
        return expenseRepository.findByDateBetween(startDate, endDate).stream().mapToDouble(Expense::getAmtSpent).sum();
    }

    public double getCurrentBalance() {
        // Placeholder for balance calculation
        return getTotalAmount(); // Assume current balance equals total amount for simplicity
    }
}

