package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class ExpenseReportMain {

	public static void main(String[] args) {
		FERService ferservice = new FERServiceImpl();
		int userId=2;
		String ExpenseType="product1";
		String FromDate="2019-12-22";
		String ToDate="2019-12-20";

		List<Expense> expense= ferservice.expenseReport(userId, ExpenseType, FromDate, ToDate);

		if (expense == null) {
			System.out.println("no record found");
		} else {
			for(Expense expense1:expense) {
			System.out.println("expensereport:" + expense1.getExpenseType() + "," + expense1.getDate() + ","
					+ expense1.getPrice() + "," + expense1.getNoofItems() + "," + expense1.getTotal() + ","
					+ expense1.getByWhom() + "," + expense1.getUser_id());
		}
		
	}

	}
}
