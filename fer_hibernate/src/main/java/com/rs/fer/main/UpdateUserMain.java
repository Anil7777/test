package com.rs.fer.main;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class UpdateUserMain {

	public static void main(String[] args) {
		FERService ferService=new FERServiceImpl();
		
		User user=new User();
		
		user.setFirstname("subash");
		user.setMiddlename("subbu");
		user.setLastname("gjhhh");
		user.setUsername("hggffgf");
		user.setPassword("54255");
		user.setEmailid("anilggh@gmail.com");
		user.setMobileno("55656565566");
		user.setId("1");
		
		Address address=new Address();
		
		address.setId("1");
		address.setAddress1("kkjkj");
		address.setAddress2("kjkkj");
		address.setStreet("kkjklk");
		address.setCity("hyd");
		address.setState("TG");
		address.setPinCode("500031");
		address.setUser_id("1");
		
		user.setAddress(address);
		boolean updateUser=ferService.UpdateUserMain(user);
		if(updateUser) {
			System.out.println("Update User Successfully");
		}else {
			System.out.println("Update user failed");
		}
	}

}
