package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class FER_AddExpense {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();

		Expense expense = new Expense();

		expense.setExpensetype("Tea");
		expense.setDate("29/01/2020");
		expense.setPrice("100");
		expense.setNoofitems("2");
		expense.setTotal("10");
		expense.setBywhom("anu");

		boolean isAddExpense = ferService.addExpense(expense);
		if (isAddExpense) {
			System.out.println("AddExpenses completed Successfully");
		} else {
			System.out.println("AddExpense failed");
		}

	}

}
