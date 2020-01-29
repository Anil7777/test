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
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			statement = connection.prepareStatement("Insert into employee values(?,?,?,?,?)");

			for (int index = 201; index <= 300; index++) {

				statement.setInt(1, index);
				statement.setString(2, "user" + index);
				statement.setString(3, "user17");
				statement.setString(4, "12000");
				statement.setString(5, "java");

				statement.addBatch();
			}

			int[] noOfRecInserted = statement.executeBatch();
			System.out.println("no of Records Inserted:" + noOfRecInserted);
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
