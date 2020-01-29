package com.rs.fer.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementDelete {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// Register Driver
			Class.forName("com.mysql.jdbc.Driver");

			// Get Connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");

			// Create Statement
			String sql = "delete from employee WHERE id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "105");

			// Execute Statement
			int noOfRecDeleted = preparedStatement.executeUpdate();
			System.out.println("noOfRecDeleted:" + noOfRecDeleted);

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
