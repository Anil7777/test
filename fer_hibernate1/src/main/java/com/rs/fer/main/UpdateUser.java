package com.rs.fer.main;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class UpdateUser {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();

		User user = new User();
		Address address = new Address();
		user.setId(1);
		user.setFirstname("vinod");
		user.setMiddlename("kumar");
		user.setLastname("sadieni");
		user.setUsername("vinod");
		user.setPassword("qwerty");
		user.setEmail("vinod@gmail.com");
		user.setMobile("987456321");

		address.setAddressline1("mainroad");
		address.setAddressline2("madhapur");
		address.setStreet("hyd");
		address.setArea("ayyapasocity");
		address.setState("ap");
		address.setPincode("500081");
		address.setCountry("india");
		address.setUserid(2);

		user.setAddress(address);

		boolean isUpdate = ferService.updateUser(user);

		if (isUpdate) {
			System.out.println("Update user details successfully");
		} else {
			System.out.println("User details not updated");
		}

	}

}

