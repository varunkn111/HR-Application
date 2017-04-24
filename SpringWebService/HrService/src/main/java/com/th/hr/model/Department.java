package com.th.hr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;



/**
 * The persistent class for the DEPARTMENTS database table.
 * 
 */
@Entity
@Table(name="DEPARTMENTS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "DEPT_SEQ")
	@SequenceGenerator(
				name = "DEPT_SEQ",
				sequenceName="DEPT_SEQ")
	@Column(name="DEPARTMENT_ID")
	private int departmentId;

	@Lob
	@Column(name="DEPARTMENT_DETAIL")
	private String departmentDetail;

	@Column(name="DEPARTMENT_NAME")
	private String departmentName;

	@Column(name="LOCATION_ID")
	private int locationId;

	@Column(name="MANAGER_ID")
	private String managerId;

	public Department() {
	}

	

	public int getDepartmentId() {
		return departmentId;
	}



	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}



	public int getLocationId() {
		return locationId;
	}



	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}



	public String getManagerId() {
		return managerId;
	}



	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}



	public String getDepartmentDetail() {
		return this.departmentDetail;
	}

	public void setDepartmentDetail(String departmentDetail) {
		this.departmentDetail = departmentDetail;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	

}