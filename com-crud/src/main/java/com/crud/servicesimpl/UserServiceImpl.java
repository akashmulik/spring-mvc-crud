package com.crud.servicesimpl;

import java.util.List;

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
	
	public boolean createOrUpdate(UsersBean uBean) {
		
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

}
