package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class LogIn {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();

		boolean login = ferService.login("root", "root");
		if (login) {
			System.out.println("login success");
		} else {
			System.out.println("fail to login");
		}

	}
}
