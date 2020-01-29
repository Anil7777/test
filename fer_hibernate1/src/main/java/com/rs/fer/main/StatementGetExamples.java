package com.rs.fer.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatementGetExamples {

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1", "root", "root");
			statement = connection.createStatement();

			ResultSet resultset = statement
					.executeQuery("select*from user where username='user101'and password'abcd' or '1==1';");

			while (resultset.next()) {
				int id = resultset.getInt(1);
				String username = resultset.getString(2);
				String password = resultset.getString(3);
				String salary = resultset.getString(4);

				System.out.println(id + " ," + username + "," + password + "," + salary);
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
