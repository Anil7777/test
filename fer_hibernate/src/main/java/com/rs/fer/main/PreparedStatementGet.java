package com.rs.fer.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementGet {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			statement = connection.prepareStatement("select * from user where username=? and password=?");
			statement.setString(1, "admin1");
			statement.setString(2, "ABCD'or'1==1");

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String username = resultSet.getString(2);
				String password = resultSet.getString(3);
				String salary = resultSet.getString(4);
				String department = resultSet.getString(5);

				System.out.println(id + "," + username + "," + password + "," + salary + "," + department);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
