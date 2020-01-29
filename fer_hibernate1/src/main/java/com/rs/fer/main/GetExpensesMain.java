package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetExpensesMain {
	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();

		List<Expense> expenses = ferService.getExpenses(4);

		if (expenses == null) {
			System.out.println("expense fetched failed");
		} else {
			for (Expense expense : expenses) {
				System.out.println("expenses:" + expense.getExpenseType() + ":" + expense.getDate() + ":"
						+ expense.getPrice() + ":" + expense.getnoOfItems() + ":" + expense.getTotal() + ":"
						+ expense.getBywhom() + ":" + expense.getId() + ":");
			}
		}

	}
}