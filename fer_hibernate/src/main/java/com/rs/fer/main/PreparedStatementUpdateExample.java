package com.rs.fer.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementUpdateExample {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// Register Driver
			Class.forName("com.mysql.jdbc.Driver");

			// Get Connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");

			// Create Statement
			String sql = "UPDATE USER SET salary=?, department=? WHERE id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "50000");
			preparedStatement.setString(2, "JAVA");
			preparedStatement.setInt(3, 2);

			// Execute Statement
			int noOfRecAffected = preparedStatement.executeUpdate();
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
