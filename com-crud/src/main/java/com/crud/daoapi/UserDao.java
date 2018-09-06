package com.crud.daoapi;

import java.util.List;

import com.crud.entities.LoginBean;
import com.crud.entities.UsersBean;

public interface UserDao {

	public boolean createOrUpdate(UsersBean uBean);

	public UsersBean getUser(UsersBean uBean);

	public List<UsersBean> list();

	public boolean deleteUser(LoginBean bean);

	public boolean checkDuplicateEmail(String email);

	public List<UsersBean> verifyLogin(LoginBean bean);

	public List<UsersBean> getAllUsers();

	public boolean updateUser(UsersBean uBean);
}
