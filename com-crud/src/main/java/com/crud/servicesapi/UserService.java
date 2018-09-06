package com.crud.servicesapi;

import java.util.List;

import com.crud.entities.LoginBean;
import com.crud.entities.UsersBean;

public interface UserService {

	public boolean createOrUpdate(UsersBean uBean);
	
	public boolean updateUser(UsersBean uBean);
	
	public boolean checkDuplicateEmail(String email);

	public List<UsersBean> verifyLogin(LoginBean bean);

	public List<UsersBean> getAllUsers();

	public boolean deleteUser(LoginBean bean);

}
