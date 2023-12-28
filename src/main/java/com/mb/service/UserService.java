package com.mb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mb.dao.UserDao;

@Service
public class UserService {
	private PwdService pwdService;
	private UserDao userDao;
	private EmailService emailService;
	
//	@Autowired
//	public void setPwdService(PwdService pwdService) {
//		this.pwdService = pwdService;
//	}
//
//	@Autowired
//	public void setUserDao(UserDao userDao) {
//		this.userDao = userDao;
//	}
//
//	@Autowired
//	public void setEmailService(EmailService emailService) {
//		this.emailService = emailService;
//	}
	
	

	public void registerUser(String name, String email, String pwd) {
//		encrypt pwd
		String encryptPwd = pwdService.encryptPwd(pwd);
//		save user in db
		boolean isSaved = userDao.saveUser(name, email, encryptPwd);
//		send email
		if(isSaved) {
			boolean isSent = emailService.sendEmail(email, "Test subject", "Test body");
			if(isSent) {
				System.out.println("User reg completed");
			}
		}
		
	}

	@Autowired
public UserService(PwdService pwdService, UserDao userDao, EmailService emailService) {
	this.pwdService = pwdService;
	this.userDao = userDao;
	this.emailService = emailService;
}

}
