package com.rs.fer.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.util.DBUtil;
import com.rs.fer.util.HBUtil;

public  class FERServiceImpl implements FERService {
	public boolean registration(User user) {
		boolean isRegister = false;
		try {
			Integer numberOfRecordInserted = (Integer) HBUtil.getSession().save(user);
			HBUtil.getTranctionCommit();
			System.out.println("no of records inserted:" + numberOfRecordInserted);
			isRegister = numberOfRecordInserted > 0;
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




	public boolean addexpense(Expense expense) {
		boolean isAddexpense=false;
	
		

		Connection connection = null;
		PreparedStatement statement = null;

		try {

			connection = DBUtil.getConnection();
			statement = connection.prepareStatement("insert into expense (expenseType, date, price, noofitems, total, bywhom, userid) values(?,?,?,?,?,?,?);");
			
			statement.setString(1, expense.getExpensetype());
			statement.setString(2, expense.getDate());
			statement.setString(3, expense.getPrice());
			statement.setString(4, expense.getNoofitems());
			statement.setString(5, expense.getTotal());
			statement.setString(6, expense.getBywhom());
			statement.setInt(7, expense.getUserid());
			

			int numOfRecUpdate = statement.executeUpdate();
			System.out.println("row updated:" + numOfRecUpdate);
			
			 return isAddexpense=(numOfRecUpdate>0);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			DBUtil.closeConnection(connection);

		}

	return isAddexpense;
	}
	
	public boolean editexpense(Expense expense) {
		boolean isEditexpense=false;
	
		

		Connection connection = null;
		PreparedStatement statement = null;

		try {

			connection = DBUtil.getConnection();
			statement = connection.prepareStatement("update  expense set expensetype=?, date=?, price=?, noofitems=?, total=?, bywhom=?, userid=? where id=?");
			
			statement.setString(1, expense.getExpensetype());
			statement.setString(2, expense.getDate());
			statement.setString(3, expense.getPrice());
			statement.setString(4, expense.getNoofitems());
			statement.setString(5, expense.getTotal());
			statement.setString(6, expense.getBywhom());
			statement.setInt(7, expense.getUserid());
			statement.setInt(8, expense.getId());
			

			int noOfRecUpdate = statement.executeUpdate();
			System.out.println("numOfRecAffected:" + noOfRecUpdate);
			
			isEditexpense=(noOfRecUpdate>0);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return isEditexpense;

		}

		
		public boolean deleteexpense(int expenseId) {
			boolean isDeleteexpense=false;

			Connection connection = null;
			PreparedStatement statement = null;
			try {

				connection = DBUtil.getConnection();
				statement = connection.prepareStatement("delete from expense where id=?"); 
				statement.setInt(1, expenseId);
				

				int noOfRecAffected = statement.executeUpdate();
				System.out.println("row updated:" + noOfRecAffected);
				isDeleteexpense=(noOfRecAffected>0);
				
				
    } catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.closeConnection(connection);
			}
			return isDeleteexpense;
		}
				
		public boolean resetPassword(int userId, String currentPassword, String newPassword) {

			boolean resetPassword = false;
			Session session = HBUtil.getSession();
			try {
				User user = (User) session.load(User.class, userId);
				if (currentPassword.equals(user.getPassword())) {
					user.setPassword(newPassword);
					HBUtil.getTranctionCommit();
					resetPassword = true;
				}
				System.out.println(newPassword + ", " + userId + ", " + currentPassword);

			} catch (Exception e) {
				resetPassword = false;
				e.printStackTrace();
			} finally {
				HBUtil.closeSession();
			}

			return resetPassword;
		}


	
		
		public Expense getExpense(int expenseId) {
			Connection connection = null;
			PreparedStatement statement = null;
			Expense expense = new Expense();

			try {
				
				connection = DBUtil.getConnection();
				statement = connection.prepareStatement("select*from expense where id=?");

				statement.setInt(1, expenseId);
				ResultSet resultSet = statement.executeQuery();
				while (resultSet.next()) {
				
					
					
					expense.setId(resultSet.getInt("id"));
					expense.setExpensetype(resultSet.getString("ExpenseType"));
					expense.setDate(resultSet.getString("date"));
					expense.setPrice(resultSet.getString("Price"));
					expense.setNoofitems(resultSet.getString("noOfItems"));
					expense.setTotal(resultSet.getString("Total"));
					expense.setBywhom(resultSet.getString("byWhom"));
					expense.setUserid(resultSet.getInt("Userid"));
				 
					}

			}  catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.closeConnection(connection);
				}
		return expense;
		
	
}
		
		public List<Expense> getExpenses(int userId) {
			List<Expense> expenses = new ArrayList<Expense>();
			Connection connection = null;
			PreparedStatement statement = null;
			try 
			{
				connection = DBUtil.getConnection();
				statement = connection.prepareStatement("select*from expense where id=?");
                 statement.setInt(1, userId);
				ResultSet resultSet = statement.executeQuery();
				while (resultSet.next()) {
				
					Expense expense = new Expense();
					
					expense.setExpensetype(resultSet.getString("Expensetype"));
					expense.setDate(resultSet.getString("date"));
					expense.setPrice(resultSet.getString("Price"));
					expense.setNoofitems(resultSet.getString("noofitems"));
					expense.setTotal(resultSet.getString("Total"));
					expense.setBywhom(resultSet.getString("bywhom"));
					expense.setId(resultSet.getInt("id"));
					expenses.add(expense);
				 
					}

			}  catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.closeConnection(connection);
				}
		return expenses;
		
		}
		
	
		public List<Expense> expenseReport(int userid, String expensetype, String fromDate, String toDate) {
			List<Expense> expense = new ArrayList<Expense>();

			Connection connection = null;
			PreparedStatement statement = null;

			try {
				
				connection = DBUtil.getConnection();
				statement = connection.prepareStatement(" SELECT * FROM expense WHERE userid=? and date between ? And ?");

				statement.setString(1, "1");
				statement.setString(2, "19/12/2019");
				statement.setString(3, "30/12/2019");

				ResultSet resultSet = statement.executeQuery();
				while (resultSet.next()) {
					System.out.println(resultSet.getString("ExpenseType") + "," + resultSet.getString("Date") + "," + resultSet.getString("price")
							 + "," + resultSet.getString("noOfItems") + "," + resultSet.getString("Total") + "," + resultSet.getString("bywhom"));
				}

					} catch (SQLException e) {
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
			preparedstatement = connection.prepareStatement
					("select u.*,a.* from user u left join address a on u.id=a.userid where a.userid=?;");
			preparedstatement.setInt(1,userId);
			
			ResultSet resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) {
				
				user = new User();
				user.setFirstname(resultSet.getString("FirstName"));
				user.setMiddlename(resultSet.getString("Middlename"));
				user.setLastname(resultSet.getString("Lastname"));
				user.setUsername(resultSet.getString("Username"));
				user.setPassword(resultSet.getString("Password"));
				user.setEmail(resultSet.getString("Email"));
				user.setMobile(resultSet.getString("Mobile"));
				
				Address address = new Address();
				
				address.setId(resultSet.getInt("Id"));
				address.setUserid(resultSet.getInt("Userid"));
				address.setAddress1(resultSet.getString("address1"));
				address.setAddress2(resultSet.getString("address2"));
				address.setStreet(resultSet.getString("Street"));
				address.setCity(resultSet.getString("City"));
				address.setState(resultSet.getString("State"));
				address.setPincode(resultSet.getString("Pincode"));
				address.setCountry(resultSet.getString("Country"));
				
		        user.setAddress(address);
			}
			} catch (SQLException e) {
			e.printStackTrace();
				 } finally {
						DBUtil.closeConnection(connection);
					}
					
			return user;
			}
		
public boolean updateUser(User user) {

	Connection connection = null;
	PreparedStatement statement = null;
	int numRecAff = 0;
	try {
		connection = DBUtil.getConnection();

		connection.setAutoCommit(false);

		statement = connection.prepareStatement(
				"update user set firstname=?," + " middlename=?,lastname=?, email=?, mobile=? where id=?");
		statement.setString(1, user.getFirstname());
		statement.setString(2, user.getMiddlename());
		statement.setString(3, user.getLastname());
		statement.setString(4, user.getUsername());
		statement.setString(5, user.getPassword());
		statement.setString(4, user.getEmail());
		statement.setString(5, user.getMobile());
		statement.setInt(6, user.getId());

		numRecAff = statement.executeUpdate();

		System.out.println("No. of user records updated " + numRecAff);

		Address address = user.getAddress();
		String query = "";
		if (numRecAff > 0) {
			if (address.getId() == 0) {
				query = "insert into address (addressline1 , addressline2, street , area , state , pincode , country, userid) values(?,?,?,?,?,?,?,?)";
			} else {
				query = "update address set addressline1 = ? , addressline2 = ?, street=?, area = ? ,state = ? ,pincode = ?, country=? where userid = ?";
			}
			statement = connection.prepareStatement(query);
			statement.setString(1, address.getAddress1());
			statement.setString(2, address.getAddress2());
			statement.setString(3, address.getStreet());
			statement.setString(4, address.getCity());
			statement.setString(5, address.getState());
			statement.setString(6, address.getPincode());
			statement.setString(7, address.getCountry());
			statement.setInt(8, address.getUserid());

			numRecAff = statement.executeUpdate();

			System.out.println("No. of address records updated " + numRecAff);

			if (numRecAff > 0) {
				connection.commit();
			} else {
				connection.rollback();
			}

			System.out.println(user.getFirstname() + "," + user.getMiddlename() + "," + user.getLastname() + ","
					+ user.getEmail() + "," + user.getMobile() + "," + user.getId() + "," + address.getAddress1()
					+ "," + address.getAddress2() + "," + address.getStreet() + "," + address.getCity() + ","
					+ address.getState() + "," + address.getPincode() + "," + address.getCountry());
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		DBUtil.closeConnection(connection);
	}
	return numRecAff > 0;

}
public boolean resetpassword(int id, String currentpassword, String newpassword) {
	// TODO Auto-generated method stub
	return false;
}

}



	