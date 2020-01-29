package com.rs.fer.main;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetUserMain {

	public static void main(String[] args) {

		FERService ferService = new FERServiceImpl();

		User user = ferService.getUser(3);
		Address address = user.getAddress();

		System.out.println("Firstname: " + user.getFirstname());
		System.out.println("Middlename: " + user.getMiddlename());
		System.out.println("Lastname: " + user.getLastname());
		System.out.println("Username: " + user.getUsername());
		System.out.println("Password: " + user.getPassword());
		System.out.println("Email: " + user.getEmail());
		System.out.println("Mobile: " + user.getMobile());

		System.out.println("Addressline1:" + address.getAddressline1());
		System.out.println("Addressline2:" + address.getAddressline2());
		System.out.println("Street:" + address.getStreet());
		System.out.println("Area:" + address.getArea());
		System.out.println("State:" + address.getState());
		System.out.println("Pincode:" + address.getPincode());
		System.out.println("Country:" + address.getCountry());
		System.out.println("UserId:" + address.getUserid());
	}
}
