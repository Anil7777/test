package com.rs.fer.main;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementGet {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			statement = connection.createStatement();

			ResultSet resultSet = statement
					.executeQuery("select * from user where username='user101' and password='ABCD' or '1==1';");
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
