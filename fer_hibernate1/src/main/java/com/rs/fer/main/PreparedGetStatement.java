package com.rs.fer.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedGetStatement {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement statement = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1", "root", "root");
			statement = connection.prepareStatement("select * from user where name = ? and password =?;");
			statement.setString(1, "user8");
			statement.setString(2, "user8");

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);

				String username = resultSet.getString(2);
				String password = resultSet.getString(3);
				int salary = resultSet.getInt(4);

				System.out.println(id + " ," + username + " , " + password + ", " + salary);
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
