package com.ghis.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ghis.util.HibernateUtil;

public class AppContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("GHIS Destroyed!!!!");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("GHIS Initialized!!!!");
		HibernateUtil.getSessionFactory();
	}

}
