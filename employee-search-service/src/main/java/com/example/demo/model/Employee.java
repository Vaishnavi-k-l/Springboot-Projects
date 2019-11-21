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

@Data
@Entity
@Table(name ="employee")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Employee
{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name= "employee_id")
		private Long employeeId;

		@Column(name = "emp_name")
		private String name;

		@Column(name = "practice_area")
		private String practiceArea;

		@Column(name = "designation")
		private String designation;

		@Column(name = "company_info")
		private String companyInfo;

	  	 

	  

}
