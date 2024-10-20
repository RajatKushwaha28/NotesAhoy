package com.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider 
{
	public static SessionFactory factory; 
	
	public static SessionFactory getSessionFactory()
	{
		if(factory == null)
		{
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			factory = cfg.buildSessionFactory();
		}
		return factory;
	}
	
	public void closeSessionFactory()
	{
		if(factory.isOpen())
		{
			factory.close();
		}
	}
}
