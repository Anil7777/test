package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class FER_DeleteExpense {

	public static void main(String[] args) {
		FERService ferservice = new FERServiceImpl();

		boolean isDeleted = ferservice.deleteExpense(1);
		if (isDeleted) {
			System.out.println("Expense Deleted Successfully");
		} else {
			System.out.println("Expense Deleted failed");
		}
	}

}
