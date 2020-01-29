package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetExpenseMain {
	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		int expenseid = 5;
		Expense expense = ferService.getExpense(expenseid);
		if (expense == null) {
			System.out.println("expense fetched failed:" + expense);
		} else {
			System.out.println("expense:" + expense.getExpenseType() + ":" + expense.getDate() + ":"
					+ expense.getPrice() + ":" + expense.getnoOfItems() + ":" + expense.getTotal() + ":"
					+ expense.getBywhom() + ":" + expense.getUserid() + ":");

		}
	}
}