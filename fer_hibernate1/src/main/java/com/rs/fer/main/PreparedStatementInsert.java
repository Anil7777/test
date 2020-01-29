package com.rs.fer.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementInsert {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement statement = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1", "root", "root");
			statement = connection.prepareStatement("insert into user values(?,?,?,?,?);");

			for (int index = 1; index <= 100; index++) {
				statement.setInt(1, index);
				statement.setString(2, "User");
				statement.setString(3, "user8");
				statement.setString(4, "2345");
				statement.setString(5, "java");
				statement.addBatch();
			}

			int[] noOfRecInserted = statement.executeBatch();
			System.out.println("no of records inserted:" + noOfRecInserted);

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
