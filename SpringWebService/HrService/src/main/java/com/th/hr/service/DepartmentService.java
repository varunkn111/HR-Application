package com.th.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.th.hr.dao.DepartmentDao;
import com.th.hr.model.Department;



public class DepartmentService {
	@Autowired
	DepartmentDao deptDao;
	public Department findDepartment(int departmentId){
		/*ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		DepartmentDao deptDao = (DepartmentDao) context.getBean("department");*/
		
		//DepartmentDao deptDao = new DepartmentDao();
		Department dept = deptDao.findDepartment(departmentId);
		return dept;
}
	public boolean deleteEntity(int id) throws Exception {
		return deptDao.deleteEntity(id);
}
	public List getDepartmentList() throws Exception {
		return deptDao.getDepartmentList();
		
	}
	public void insertDepartment(Department department){
		deptDao.insert(department);
	}
}