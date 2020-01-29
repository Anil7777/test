package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class DeleteExpense {
	public static Expense expense;

		public static void main(String[] args) {
			FERService ferService = new FERServiceImpl();
			Expense expense = new Expense();
			expense.setId(6);

			boolean isDeleteexpense = ferService.deleteexpense(6);
			if (isDeleteexpense) {
				System.out.println("deleteexpense is successfully");
			} else {
				System.out.println("deleteexpense failed");
			}

		}

	}
