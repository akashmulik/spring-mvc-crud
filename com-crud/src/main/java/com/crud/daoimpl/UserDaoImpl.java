package com.crud.daoimpl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crud.daoapi.UserDao;
import com.crud.entities.LoginBean;
import com.crud.entities.UsersBean;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean createOrUpdate(UsersBean uBean) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(uBean);
		return true;
	}
	
public boolean updateUser(UsersBean uBean) {
		
	try {
		Query query = sessionFactory.getCurrentSession().createQuery("update UsersBean set name= :name, email= :email,"
				+ "mobile= :mob, city= :city where id= :id");
		query.setString("name",uBean.getName());
		query.setString("email", uBean.getEmail());
		query.setString("mob", uBean.getMobile());
		query.setString("city", uBean.getCity());
		query.setLong("id", uBean.getId());
		query.executeUpdate();
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
}
	
	public List<UsersBean> verifyLogin(LoginBean bean) {
		
		Query query = sessionFactory.getCurrentSession().createQuery("FROM UsersBean bean WHERE bean.email=:email and bean.pswd=:pswd");
		query.setString("email", bean.getEmail());
		query.setString("pswd", bean.getPswd());
		return query.list();
	}

	public UsersBean getUser(UsersBean uBean) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UsersBean> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteUser(LoginBean uBean) {

		try {
			//first load the bean and then pass it in delete fun
			//UsersBean bean = (UsersBean) sessionFactory.getCurrentSession().load(UsersBean.class, 61);
			//sessionFactory.getCurrentSession().delete(bean);
			Query query = sessionFactory.getCurrentSession().createQuery("delete from UsersBean where email= :email");
			query.setString("email", uBean.getEmail());
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean checkDuplicateEmail(String email) {

		Query query = sessionFactory.getCurrentSession()
				.createQuery("SELECT COUNT(*) FROM UsersBean bean WHERE bean.email=:email");
		query.setString("email", email);
		int count = (int) (long) (Long) query.uniqueResult();
		if (count == 0)
			return true;

		return false;
	}

	public List<UsersBean> getAllUsers() {
		
		Query query = sessionFactory.getCurrentSession().createQuery("from UsersBean");
		return query.list();
	}

}
