package com.rs.fer.main;


import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class RegistrationMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();

		User user = new User();

		user.setFirstname("gopi");
		user.setMiddlename("nath");
		user.setLastname("hi");
		user.setUsername("root");
		user.setPassword("root");
		user.setEmail("gopi@rs.com");
		user.setMobile("12345");

		boolean isRegister = ferService.registration(user);

		if (isRegister) {
			System.out.println("Registration is done successfully...");
		} else {
			System.out.println("Registration is failed...");
		}

	}
	}

