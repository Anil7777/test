package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class AddExpense {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		Expense expense = new Expense();
		expense.setExpenseType("tea");
		expense.setDate("20-12-2019");
		expense.setPrice("23");
		expense.setnoOfItems("4");
		expense.setTotal("20000");
		expense.setBywhom("vinod");
		expense.setUserid("5");

		boolean isAddexpense = ferService.addexpense(expense);
		if (isAddexpense) {
			System.out.println("addexpense is successfully");
		} else {
			System.out.println("addexpense failed");
		}

	}

}
