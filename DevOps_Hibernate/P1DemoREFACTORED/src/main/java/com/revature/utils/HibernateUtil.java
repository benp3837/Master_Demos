package com.revature.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static Session ses;
	private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	//remember - we use the SessionFactory interface to create Sessions.
	//and we use Sessions to open (and close) connections to our database. 
		//we'll open a session in each of our DAO methods, then use the session methods to do database operations.
	
	//method to open sessions
	public static Session getSession() {
		if(ses==null) {
			ses=sf.openSession();
		}
		return ses;
	}
	
	//method to close sessions
	public static void closeSession() {
		ses.close();
		ses=null;
	}
	
}
