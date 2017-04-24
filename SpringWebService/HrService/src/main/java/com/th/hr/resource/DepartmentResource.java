package com.th.hr.resource;

import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.th.hr.model.Department;
import com.th.hr.model.Status;
import com.th.hr.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentResource {

 @Autowired
 DepartmentService departmentService;

 static final Logger logger = Logger.getLogger(DepartmentResource.class);

 

 /* Ger a single objct in Json form in Spring Rest Services */
 @RequestMapping(value = "/{id}", method = RequestMethod.GET)
 public @ResponseBody
 Department findDepartment(@PathVariable("id") int id) {
	 System.out.println(id);
  Department dept = null;
  try {
  dept = departmentService.findDepartment(id);

  } catch (Exception e) {
   e.printStackTrace();
  }
  return dept;
 }
 /* Getting List of objects in Json format in Spring Restful Services */
 @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
 public @ResponseBody
 List getDepartment() {

  List deptList = null;
  try {
   deptList = departmentService.getDepartmentList();

  } catch (Exception e) {
   e.printStackTrace();
  }

  return deptList;
 }
 /* Delete an object from DB in Spring Restful Services */
 @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
 public @ResponseBody
 Status deleteEmployee(@PathVariable("id") int id) {

  try {
   departmentService.deleteEntity(id);
   return new Status(1, "Department deleted Successfully !");
  } catch (Exception e) {
   return new Status(0, e.toString());
  }

 }
 @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
 public @ResponseBody
 void insertDepartment(@RequestBody Department department){
	 departmentService.insertDepartment(department);
 }

  }
