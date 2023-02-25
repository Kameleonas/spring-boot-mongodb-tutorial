package com.springboot.springbootmongodbtutorial.service;

import com.springboot.springbootmongodbtutorial.model.Expense;
import com.springboot.springbootmongodbtutorial.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense) {
        this.expenseRepository.insert(expense);
    }

    public void updateExpense(Expense expense) {
      Optional<Expense> savedExpense = expenseRepository.findById(expense.getId());

      if (savedExpense.isPresent()) {
          savedExpense.get().setExpenseName(expense.getExpenseName());
          savedExpense.get().setExpenseCategory(expense.getExpenseCategory());
          savedExpense.get().setExpenseAmount(expense.getExpenseAmount());

          expenseRepository.save(expense);
      }
      else {
          System.out.printf("Cannot Find Expense by ID %s", expense.getId());
      }
    }

    public List<Expense> getAllExpenses() {
        return this.expenseRepository.findAll();
    }
    public Expense getExpenseByName(String name) {
        return expenseRepository.findByName(name).orElseThrow(()-> new RuntimeException(
                String.format("Cannot Find Expense by Name %s", name)
        ));

    }
    public void deleteExpense(String id) {
        expenseRepository.deleteById(id);
    }

}
