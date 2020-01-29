package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class FER_Login {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();

		boolean login=ferService.login("rajasri","admin");

		if (login) {
			System.out.println("Login Success");
		} else {
			System.out.println("failed to login");
		}

	}

}