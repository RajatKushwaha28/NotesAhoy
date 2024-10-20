package com.DAO;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.entity.Admin;
import com.entity.User;
import com.helper.FactoryProvider;

public class UserDAO {
	
	public boolean verifyUser(String email, String pass)
	{
		Session sess = FactoryProvider.getSessionFactory().openSession();
		Transaction T = sess.beginTransaction();
		Criteria crit = sess.createCriteria(User.class);
		crit.add(Restrictions.eq("email", email));
		crit.add(Restrictions.eq("password", pass));
		T.commit();
		List<User> L = crit.list();
		if(L.isEmpty())
			return false;
		else
			return true;
	}
	
	public boolean saveUser(User user)
	{
		Session sess = FactoryProvider.getSessionFactory().openSession();
		Transaction T = sess.beginTransaction();
		Serializable i = sess.save(user);
		T.commit();
		if(i==null)
			return false;
		sess.close();
		return true;
	}
	
	public User getUser(String email)
	{
		Session sess = FactoryProvider.getSessionFactory().openSession();
		Transaction T = sess.beginTransaction();
		User u = sess.get(User.class, email);
		T.commit();
		sess.close();
		return u;
	}
	
	public List<User> getAllUsers(Admin a)
	{
		Session sess = FactoryProvider.getSessionFactory().openSession();
		Transaction T = sess.beginTransaction();
		Criteria crit = sess.createCriteria(User.class);
		crit.add(Restrictions.eq("Admin", a));
		T.commit();
		List<User> L = crit.list();
		return L;
	}
	
	public void deleteUser(String email)
	{
		Session sess = FactoryProvider.getSessionFactory().openSession();
		Transaction T = sess.beginTransaction();
		User user = (User) sess.get(User.class, email);
		sess.delete(user);
		T.commit();
		sess.close();
	}
	
	
}
