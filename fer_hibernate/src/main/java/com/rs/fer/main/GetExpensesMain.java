package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetExpensesMain {

	

	public static void main(String[] args) {
		FERService ferservice = new FERServiceImpl();

		List<Expense> expenses= ferservice.getExpenses(2);

		if (expenses == null) {
			System.out.println("expense fetched failed:");
		} else {
			for(Expense expense:expenses) {
			System.out.println("expenses:" + expense.getExpenseType() + "," + expense.getDate() + ","
					+ expense.getPrice() + "," + expense.getNoofItems() + "," + expense.getTotal() + ","
					+ expense.getByWhom() + "," + expense.getUser_id());
		}
	}

}
}
