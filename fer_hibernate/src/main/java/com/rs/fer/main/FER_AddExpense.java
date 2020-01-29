package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class FER_AddExpense {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();

		Expense expense = new Expense();

		expense.setExpensetype("Product");
		expense.setDate("2019-12-23");
		expense.setPrice("800");
		expense.setNoofitems("3");
		expense.setTotal("10");
		expense.setBywhom("anil");

		boolean isAddExpense = ferService.addExpense(expense);
		if (isAddExpense) {
			System.out.println("AddExpenses completed Successfully");
		} else {
			System.out.println("AddExpense failed");
		}

	}

}
