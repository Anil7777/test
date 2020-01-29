package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class ExpenseReportMain {
	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();
		int userid = 1;
		String expenseType = "tea";
		String fromDate = "19/12/2019";
		String toDate = "30/12/2019";

		List<Expense> expense = ferService.expenseReport(userid, expenseType, fromDate, toDate);
		if (expense == null) {
			System.out.println("no records found");
		} else {
			for (Expense expense1 : expense) {
				System.out.println("expensereport:" + expense1.getExpenseType() + "," + expense1.getDate() + ":"
						+ expense1.getPrice() + ":" + expense1.getnoOfItems() + ":" + expense1.getTotal() + ":"
						+ expense1.getBywhom() + ":" + expense1.getUserid());
			}

		}

	}
}