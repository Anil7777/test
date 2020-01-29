package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetExpenseMain {

	public static void main(String[] args) {
		FERService ferservice = new FERServiceImpl();
        
		
		
		int expenseId = 4;

		Expense expense = ferservice.getExpense(expenseId);

		if (expense==null) {
			System.out.println("expense fetched failed:" + expense);
		} else {
			System.out.println("expense:"+expense.getExpenseType()+ "," + expense.getDate()+ "," +expense.getPrice()+ ","
					+expense.getNoofItems()+ "," +expense.getTotal()+ "," +expense.getByWhom()+","
					+expense.getUser_id());
		}

	}
}