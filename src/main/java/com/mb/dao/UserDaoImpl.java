package com.mb.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public boolean saveUser(String name, String email, String pwd) {
		// TODO Auto-generated method stub
		System.out.println("record inserted in db");
		return true;
	}

}
