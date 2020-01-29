package com.rs.fer.main;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class RegistrationMain {

	public static void main(String[] args) {
		FERService ferService = new FERServiceImpl();

		User user = new User();
		user.setFirstname("raja");
		user.setMiddlename("sri");
		user.setLastname("Infotech");

		user.setUsername("rajasri");
		user.setPassword("admin");

		user.setEmailid("rajasri@gamil.com");
		user.setMobileno("9951532622");

		boolean isRegister = ferService.registration(user);
		if (isRegister) {
			System.out.println("Registartion Completed Successfully");
		} else {
			System.out.println("Registartion failed");
		}
	}

}
