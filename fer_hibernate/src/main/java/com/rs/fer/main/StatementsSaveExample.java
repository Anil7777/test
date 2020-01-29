package com.rs.fer.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementsSaveExample {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");

			for (int index = 1; index <= 100; index++) {

				statement = connection.createStatement();

				int noOfRecInserted = statement.executeUpdate(
						"Insert into user(username,password)values('user" + index + "','user" + index + "');");

				System.out.println("no of records Inserted:" + noOfRecInserted);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
