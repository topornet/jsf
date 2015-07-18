package com.org.jsf.managedBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.org.jsf.dao.UserDao;
import com.org.jsf.domain.User;

@Named
@RequestScoped
public class UserManagedBean {
	
	
	private User user;
	@Inject
	private UserDao userDao;
	
	public UserManagedBean(){
		user = new User();
	}
		
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void salvar(){
		try {
			userDao.salvar(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
