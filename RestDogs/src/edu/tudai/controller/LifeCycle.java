package edu.tudai.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import edu.tudai.dao.jpa.JPADAOFactory;

@WebListener
public class LifeCycle implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent arg) {
		JPADAOFactory.getInstance();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg) {
		JPADAOFactory.getInstance().close();
	}
}
