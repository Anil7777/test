package com.rs.fer.main;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class GetUserMain {

	

	public static void main(String[] args) {
		FERService ferservice = new FERServiceImpl();
		
		User user=ferservice.getUser(16);
		
		Address address=user.getAddress();
		
		
		System.out.println("FirstName:"+user.getFirstname());
		System.out.println("MiddleName:"+user.getMiddlename());
		System.out.println("LastName:"+user.getLastname());
		System.out.println("UserName:"+user.getUsername());
		System.out.println("Password:"+user.getPassword());
		System.out.println("EmailId:"+user.getEmailid());
		System.out.println("MobileNo:"+user.getMobileno());
		
		
		System.out.println("Id:"+user.getId());
		System.out.println("Address1:"+address.getAddress1());
		System.out.println("Address2:"+address.getAddress2());
		System.out.println("Strret:"+address.getStreet());
		System.out.println("City:"+address.getCity());
		System.out.println("State:"+address.getState());
		System.out.println("PinCode:"+address.getPinCode());
		System.out.println("User_Id:"+address.getUser_id());
	}

}

