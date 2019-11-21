package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Column(name = "emp_name")
	private String empName;
	
	@Id
	@Column(name = "id")
	private String empId;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + "]";
	}
}
