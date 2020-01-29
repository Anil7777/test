package com.rs.fer.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementUpdateExample {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;

		try {
			// Register Driver
			Class.forName("com.mysql.jdbc.Driver");

			// Get Connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");

			// Create Statement
			statement = connection.createStatement();

			// Execute Statement
			String sql = "UPDATE USER SET salary=40000,department='JAVA' WHERE id=6;";
			int noOfRecAffected = statement.executeUpdate(sql);
			System.out.println("noOfRecAffected:" + noOfRecAffected);

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
