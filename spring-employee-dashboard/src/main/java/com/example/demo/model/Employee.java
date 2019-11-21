package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Employee
{
		
		private Long employeeId;

		
		private String name;

		private String practiceArea;

		private String designation;

		private String companyInfo;

	  	 

	  

}





/*
 * public class Employee { private Long employeeId;
 * 
 * private String name;
 * 
 * private String practiceArea;
 * 
 * private String designation;
 * 
 * private String companyInfo;
 * 
 * public Long getEmployeeId() {
 * 
 * return employeeId;
 * 
 * }
 * 
 * public void setEmployeeId(Long employeeId) {
 * 
 * this.employeeId = employeeId;
 * 
 * }
 * 
 * public String getName() {
 * 
 * return name;
 * 
 * }
 * 
 * public void setName(String name) {
 * 
 * this.name = name;
 * 
 * }
 * 
 * public String getPracticeArea() {
 * 
 * return practiceArea;
 * 
 * }
 * 
 * public void setPracticeArea(String practiceArea) {
 * 
 * this.practiceArea = practiceArea;
 * 
 * }
 * 
 * public String getDesignation() {
 * 
 * return designation;
 * 
 * }
 * 
 * public void setDesignation(String designation) {
 * 
 * this.designation = designation;
 * 
 * }
 * 
 * public String getCompanyInfo() {
 * 
 * return companyInfo;
 * 
 * }
 * 
 * public void setCompanyInfo(String companyInfo) {
 * 
 * this.companyInfo = companyInfo;
 * 
 * }
 * 
 * @Override
 * 
 * public String toString() {
 * 
 * return "Employee [employeeId=" + employeeId + ", name=" + name +
 * ", practiceArea=" + practiceArea
 * 
 * + ", designation=" + designation + ", companyInfo=" + companyInfo + "]";
 * 
 * }
 * 
 * }
 */