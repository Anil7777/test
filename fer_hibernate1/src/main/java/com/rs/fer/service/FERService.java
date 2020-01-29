package com.rs.fer.service;

import java.util.List;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;

public interface FERService {

	boolean registration(User user);

	boolean login(String username, String password);

	boolean addexpense(Expense expense);

	boolean editexpense(Expense expense);

	boolean resetpassword(int Userid, String currentpassword, String newpassword);

	Expense getExpense(int expenseId);

	List<Expense> getExpenses(int userId);

	boolean deleteexpense(int expensseid);

    List<Expense> expenseReport(int userid, String expensetype, String fromDate, String toDate);

	User getUser(int userId);
	
	boolean updateUser(User user);

}
