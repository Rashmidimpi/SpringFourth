package com.mb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.mb.service.UserService;

@SpringBootApplication
public class FourthAppAutowiring2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
		SpringApplication.run(FourthAppAutowiring2Application.class, args);
		UserService userService = context.getBean(UserService.class);
		userService.registerUser("Ras", "ras@gmail.com", "abcd@123");
	}

}
