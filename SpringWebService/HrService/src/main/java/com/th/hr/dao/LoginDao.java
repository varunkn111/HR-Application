package com.th.hr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

import com.th.hr.model.Department;
import com.th.hr.model.Login;

public class LoginDao {

	@Autowired
	SessionFactory sessionFactory;
	Session session = null;
	
	public boolean validateUser(String userId, String password) {
		session = sessionFactory.openSession();
		
		
		Criteria cr = session.createCriteria(Login.class).setProjection(Projections.projectionList().add(Projections.property("userId"),"userId").add(Projections.property("password"),"password")).setResultTransformer(Transformers.aliasToBean(Login.class));
		cr.add(Restrictions.eq("userId", userId));
		cr.add(Restrictions.eq("password", password));
		List list = cr.list();
		
		
		
		//Long countValue = (Long) query.uniqueResult();
		//String result =  (String) query.uniqueResult();
		//ArrayList<Login> list = (ArrayList<Login>) query.list();
		
		
		
		if(list.size() > 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
