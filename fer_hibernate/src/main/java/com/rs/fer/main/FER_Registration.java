package com.rs.fer.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FER_Registration {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparestatement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fer", "root", "root");

			preparestatement = connection.prepareStatement(
					"Insert into user(FirstName,MiddleName,LastName,UserName,Password,EmailId,MobileNo)values(?,?,?,?,?,?,?);");

			preparestatement.setString(1, "user1");
			preparestatement.setString(2, "user2");
			preparestatement.setString(3, "user3");
			preparestatement.setString(4, "user4");
			preparestatement.setString(5, "12345");
			preparestatement.setString(6, "fer@gmail.com");
			preparestatement.setString(7, "9951955015");

			int noOfRegistrationsInserted = preparestatement.executeUpdate();
			System.out.println("noOfRegistartionsInserted:" + noOfRegistrationsInserted);
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
