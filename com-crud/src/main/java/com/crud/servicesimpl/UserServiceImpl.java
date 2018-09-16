package com.crud.servicesimpl;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.daoapi.UserDao;
import com.crud.entities.LoginBean;
import com.crud.entities.UsersBean;
import com.crud.servicesapi.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	static final private Log log = LogFactory.getLog(UserServiceImpl.class);

	//create user
	public boolean createOrUpdate(UsersBean uBean) {

		//using apache commons lang dependency
		//String generatedString = RandomStringUtils.randomAlphabetic(10);
		
		//generate random password string
		final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		int count = 5;
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
		int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
		builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
	    log.info(builder);
	    uBean.setPswd(builder.toString());
		return userDao.createOrUpdate(uBean);
	}

	public boolean updateUser(UsersBean uBean) {

		return userDao.updateUser(uBean);
	}

	public boolean checkDuplicateEmail(String email) {

		return userDao.checkDuplicateEmail(email);
	}

	public List<UsersBean> verifyLogin(LoginBean bean) {

		return userDao.verifyLogin(bean);
	}

	public List<UsersBean> getAllUsers() {

		return userDao.getAllUsers();
	}

	public boolean deleteUser(LoginBean bean) {

		return userDao.deleteUser(bean);
	}

	public boolean toggleUserStatus(UsersBean bean) {
		return userDao.toggleUserStatus(bean);
	}

}
