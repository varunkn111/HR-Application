package com.th.hr.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.th.hr.dao.LoginDao;

public class LoginService {

	@Autowired
	LoginDao loginDao;
	public boolean validateUser(String userId, String password) {
		return loginDao.validateUser(userId, password);	
	}
	
}