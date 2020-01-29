package com.rs.fer.main;


import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class ResetPassword {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();

		boolean resetPassword = ferService.resetpassword(1,"root", "root1");

		if (resetPassword) {
			System.out.println("resetPassword success");
		} else {
			System.out.println("fail to resetPassword");
		}

	}

}
