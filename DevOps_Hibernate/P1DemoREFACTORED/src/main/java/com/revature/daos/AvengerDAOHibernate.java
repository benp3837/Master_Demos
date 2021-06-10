package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Avenger;
import com.revature.utils.HibernateUtil;

public class AvengerDAOHibernate implements AvengerInterface {

	//If you have no idea what's going on here, check the Session Methods section in the Hibernate notes!!!
	//That will give you an idea of what each of these methods are doing to your Database.

	@Override
	public List<Avenger> getAvengers() {
		Session ses = HibernateUtil.getSession();
		List<Avenger> list = ses.createQuery("FROM Avenger").list();
		return list;
	}

	@Override
	public Avenger getAvengerById(int id) {
		Session ses = HibernateUtil.getSession();
		Avenger a = ses.get(Avenger.class, id);
		return a;
	}

	@Override
	public boolean addAvenger(Avenger a) {
		Session ses = HibernateUtil.getSession();
		//I'm using a try/catch here, since the method is supposed to return a boolean.
		//If the insert is successful, we'll return true. else, return false. 
		try {
			ses.save(a);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateAvenger(Avenger a) {
		Session ses = HibernateUtil.getSession();
		try {
			ses.merge(a);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean killAvenger(int id) {
		Session ses = HibernateUtil.getSession();
		Avenger a = getAvengerById(id); //kind of clever right? 
		//We're using a DAO method to provide a value for this DAO method, 
		//since delete() requires an object. (An entity).
		try {
			ses.delete(a);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
