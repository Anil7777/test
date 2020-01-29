package com.rs.fer.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.util.HBUtil;

public class FERServiceImpl implements FERService {

	public boolean registration(User user) {
		boolean isRegister = false;

		try {

			Integer noOfRecordsInserted = (Integer) HBUtil.getSession().save(user);
			HBUtil.getTransactionCommit();

			System.out.println("noOfRecordsInserted:" + noOfRecordsInserted);

			isRegister = (noOfRecordsInserted > 0);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			HBUtil.closeSession();
		}
		return isRegister;
	}

	public boolean login(String username, String password) {
		boolean isLogin = false;
		try {

			isLogin = HBUtil.getSession().createQuery("from User u where u.username=? and u.password=?")
					.setParameter(0, username).setParameter(1, password).list().stream().iterator().hasNext();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			HBUtil.closeSession();
		}
		return isLogin;
	}

	
	public boolean addExpense(Expense expense) {
		boolean isAddExpense = false;
		

		try {

			Integer noOfRecInserted = (Integer) HBUtil.getSession().save(expense);
            HBUtil.getTransactionCommit();
			
			System.out.println("no of Rec Inserted:" + noOfRecInserted);
			isAddExpense = (noOfRecInserted>0);
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			HBUtil.closeSession();
		}
		return isAddExpense;

	}

	@Override
	public boolean editExpense(Expense expense) {
		boolean isEditExpense = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			connection = DBUtil.getConnection();
			String sql = ("UPDATE expense SET ExpenseType=?, Date=?, Price=?, NoofItems=?, Total=?, ByWhom=? WHERE user_id=?");

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, expense.getExpenseType());
			preparedStatement.setString(2, expense.getDate());
			preparedStatement.setString(3, expense.getPrice());
			preparedStatement.setString(4, expense.getNoofItems());
			preparedStatement.setString(5, expense.getTotal());
			preparedStatement.setString(6, expense.getByWhom());
			preparedStatement.setInt(7, expense.getUser_id());

			int noOfEditExpenses = preparedStatement.executeUpdate();
			System.out.println("noOfEditExpenses:" + noOfEditExpenses);
			isEditExpense = (noOfEditExpenses > 0);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return isEditExpense;
	}

	@Override
	public boolean deleteExpense(int expenseId) {
		boolean isDeleted = false;
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DBUtil.getConnection();
			preparedstatement = connection.prepareStatement("Delete from expense where id=?;");

			preparedstatement.setInt(1, expenseId);

			int noOfDeleteExpenses = preparedstatement.executeUpdate();
			System.out.println("noOfDeleteExpenses:" + noOfDeleteExpenses);

			isDeleted = (noOfDeleteExpenses > 0);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return isDeleted;
	}

	@Override
	public boolean resetPassword(int userId, String currentPassword, String newPassword) {
		boolean resetPassword = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement("UPDATE USER SET password=? WHERE id=? and password=?;");

			preparedStatement.setString(1, newPassword);

			preparedStatement.setInt(2, userId);

			preparedStatement.setString(3, currentPassword);

			// Execute Statement
			int noOfRecAffected = preparedStatement.executeUpdate();
			System.out.println("noOfRecAffected:" + noOfRecAffected);
			resetPassword = (noOfRecAffected > 0);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return resetPassword;
	}

	@Override
	public Expense getExpense(int expenseId) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		Expense expense = new Expense();

		try {

			connection = DBUtil.getConnection();

			preparedstatement = connection.prepareStatement("select * from expense where id=?;");
			preparedstatement.setInt(1, expenseId);

			ResultSet resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) {

				System.out.println(resultSet.getString("id") + "," + resultSet.getString("ExpenseType") + ","
						+ resultSet.getString("Date") + "," + resultSet.getString("Price") + ","
						+ resultSet.getString("NoofItems") + "," + resultSet.getString("Total") + ","
						+ resultSet.getString("ByWhom"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return expense;
	}

	@Override
	public List<Expense> getExpenses(int userId) {
		List<Expense> expense = new ArrayList<Expense>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		try {

			connection = DBUtil.getConnection();

			preparedstatement = connection.prepareStatement("select * from expense where user_id=?;");
			preparedstatement.setInt(1, userId);

			ResultSet resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) {

				System.out.println(resultSet.getString("id") + "," + resultSet.getString("ExpenseType") + ","
						+ resultSet.getString("Date") + "," + resultSet.getString("Price") + ","
						+ resultSet.getString("NoofItems") + "," + resultSet.getString("Total") + ","
						+ resultSet.getString("ByWhom"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return expense;

	}

	@Override
	public List<Expense> expenseReport(int userId, String expenseType, String fromDate, String toDate) {
		List<Expense> expense = new ArrayList<Expense>();
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DBUtil.getConnection();

			preparedstatement = connection
					.prepareStatement("select * from expense where user_id=? and Date between ? and ?;");
			preparedstatement.setString(1, expenseType);
			preparedstatement.setString(2, fromDate);
			preparedstatement.setString(3, toDate);

			ResultSet resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) {
				// Expense expense1=new Expense();
				System.out.println(resultSet.getString("id") + "," + resultSet.getString("ExpenseType") + ","
						+ resultSet.getString("Date") + "," + resultSet.getString("Price") + ","
						+ resultSet.getString("NoofItems") + "," + resultSet.getString("Total") + ","
						+ resultSet.getString("ByWhom"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return expense;
	}

	public User getUser(int userId) {

		User user = null;
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DBUtil.getConnection();

			preparedstatement = connection.prepareStatement(
					"select u.*,a.* from user u left join address a on u.id=a.user_id where a.user_id=?;");
			preparedstatement.setInt(1, userId);

			ResultSet resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) {

				user = new User();

				user.setFirstname(resultSet.getString("FirstName"));
				user.setMiddlename(resultSet.getString("MiddleName"));
				user.setLastname(resultSet.getString("LastName"));
				user.setUsername(resultSet.getString("UserName"));
				user.setPassword(resultSet.getString("password"));
				user.setEmailid(resultSet.getString("EmailId"));
				user.setMobileno(resultSet.getString("MobileNo"));

				Address address = new Address();
				address.setId(resultSet.getString("Id"));
				address.setAddress1(resultSet.getString("Address1"));
				address.setAddress2(resultSet.getString("Address2"));
				address.setStreet(resultSet.getString("Street"));
				address.setCity(resultSet.getString("City"));
				address.setState(resultSet.getString("State"));
				address.setPinCode(resultSet.getString("PinCode"));
				address.setUser_id("user_Id");

				user.setAddress(address);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return user;
	}

	@Override
	public boolean UpdateUserMain(User user) {
		boolean updateUser = false;
		Connection connection = null;
		PreparedStatement statement = null;

		try {

			connection = DBUtil.getConnection();

			statement = connection.prepareStatement(
					"update user set firstname=?,middlename=?,lastname=?,username=?,password=?,emailid=?,mobileno=? where id=?");

			statement.setString(1, user.getFirstname());
			statement.setString(2, user.getMiddlename());
			statement.setString(3, user.getLastname());
			statement.setString(4, user.getUsername());
			statement.setString(5, user.getPassword());
			statement.setString(6, user.getEmailid());
			statement.setString(7, user.getMobileno());
			statement.setString(8, user.getId());

			int noOfRecUpdated = statement.executeUpdate();
			System.out.println("no Of Records Updated:" + noOfRecUpdated);

			updateUser = noOfRecUpdated > 0;

			System.out.println("updateUser:" + updateUser);
			Address address = new Address();
			if (address.getId() == 0) {
				statement = connection.prepareStatement(
						"insert into address(Address1,Address2,Street,City,State,PinCode,user_id)values(?,?,?,?,?,?,?)");

				statement.setString(1, address.getAddress1());
				statement.setString(2, address.getAddress2());
				statement.setString(3, address.getStreet());
				statement.setString(4, address.getCity());
				statement.setString(5, address.getState());
				statement.setString(6, address.getPinCode());
				statement.setInt(7, address.getUser_id());
			} else {
				statement = connection.prepareStatement(
						"update address set Address1=?,Address2=?,Street=?,City=?,State=?,PinCode=? user_id=?;");

				statement.setString(1, address.getAddress1());
				statement.setString(2, address.getAddress2());
				statement.setString(3, address.getStreet());
				statement.setString(4, address.getCity());
				statement.setString(5, address.getState());
				statement.setString(6, address.getPinCode());
				statement.setInt(7, address.getUser_id());
			}
			System.out.println("statementAddress:" + statement);
			int updateAddress = statement.executeUpdate();
			System.out.println("updateAddress:" + updateAddress);
			updateUser = updateAddress > 0;

			System.out.println("updateUser:" + updateUser);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return updateUser;
	}

}
