package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.entity.Login;
public class LoginDao {
SessionFactory sf;
	public LoginDao() {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		sf =con.buildSessionFactory();
	}
	public boolean signUp(Login ll) {
		try {
			Session session  = sf.openSession();
			Transaction tran = session.getTransaction();
			tran.begin();
					session.save(ll);
			tran.commit();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public int signIn(Login ll) {
		Session session = sf.openSession();
		Query<Login> qry = session.createQuery("select ll from Login ll where ll.email = :a and ll.pass = :b");
		qry.setParameter("a", ll.getEmail());
		qry.setParameter("b", ll.getPass());
		List<Login> list = qry.list();
		return list.size();		// it return 0 if record present else return 1. 
	}
}
