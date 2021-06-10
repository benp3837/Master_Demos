package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Home;
import com.revature.utils.HibernateUtil;

public class HomeDAOHibernate implements HomeInterface {

	@Override
	public List<Home> getHomes() {
		Session ses = HibernateUtil.getSession();
		List<Home> list = ses.createQuery("FROM Home").list();
		return list;
	}

	@Override
	public Home getHomeByName(String name) {
		Session ses = HibernateUtil.getSession();
		List<Home> list = ses.createQuery("FROM Home WHERE homeName = " + name).list();
		//we can't use .get() here, because homeName isn't Serializable 
		//so it'll work in getAvengerById(), since av_id is Serializable. But not here.
		//check the implementation of .get() in the Session class. Look at what parameters it takes to see what I mean.
		Home h = list.get(0);
		return h;
	}

	@Override
	public boolean addHome(Home home) {
		Session ses = HibernateUtil.getSession();
		try {
			ses.save(home);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean destroyHome(String name) {
		Session ses = HibernateUtil.getSession();
		Home h = getHomeByName(name);
		try {
		ses.delete(h);
		return true;
		}catch(Exception e) {
		return false;
		}
	}

}
