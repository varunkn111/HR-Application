package com.th.hr.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.th.hr.model.Department;

public class DepartmentDao {
	
	@Autowired
	SessionFactory sessionFactory;
	Session session = null;
	Transaction tx = null;
	
	

	
	public Department findDepartment(int departmentId) {
		session = sessionFactory.openSession();
		Department dept = (Department) session.load(Department.class, departmentId );
		
		
		return dept;
		
	}
	public List getDepartmentList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List deptList = session.createCriteria(Department.class).list();
		tx.commit();
		session.close();
		return deptList;
	}

	
	public void insert(Department department) {
		session = sessionFactory.openSession();
		tx=session.beginTransaction();
		session.save(department);
		tx.commit();
		session.close();
		
		
	}

	
	/*public void update(Department dept) {
		
		em.getTransaction().begin();
		dept=em.find(Department.class, dept.getDepartmentId());
		
		dept.setDepartmentName("R&D New");
		em.persist(dept);
		
		
		em.getTransaction().commit();
		
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		
	}
	*/
	public boolean deleteEntity(int id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Department.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}
	
	

	

}