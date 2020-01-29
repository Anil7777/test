package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class EditExpense {
	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		Expense expense = new Expense();
		expense.setExpenseType("tea");
		expense.setDate("20-12-2019");
		expense.setPrice("23");
		expense.setnoOfItems("4");
		expense.setTotal("20000");
		expense.setBywhom("vinod");
		expense.setUserid("1");
		expense.setId(5);

		boolean isEditexpense = ferService.editexpense(expense);
		if (isEditexpense) {
			System.out.println("editexpense is successfully");
		} else {
			System.out.println("editexpense failed");
		}

	}

}
