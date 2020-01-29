package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class FER_ResetPassword {

	public static void main(String[] args) {

		FERService ferservice = new FERServiceImpl();

		int id = 14;
		String currentPassword = "67891";
		String newPassword = "54328";

		boolean resetPassword = ferservice.resetPassword(id, currentPassword, newPassword);

		if (resetPassword) {
			
			System.out.println("Password reset successfully");
		} else {
			System.out.println("Password not changed");
		}
	}

}