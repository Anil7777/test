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
			// 1.Register the driver
			Class.forName("com.mysql.jdbc.Driver");
			// 2.Get the connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1", "root", "root");
			// 3.Create the statement
			statement = connection.createStatement();
			// 4.Execute the statement
			String sql = "UPDATE USER SET salary=13000,department='aws' WHERE id=7";
			int numOfRecAffected = statement.executeUpdate(sql);
			System.out.println("numOfRecAffected:" + numOfRecAffected);

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
