package com.rest.mysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "E_Id")
	private long id;

	@Column(name = "First_Name", nullable = false)
	private String firstName;

	@Column(name = "Last_Name")
	private String lastName;

	@Column(name = "Email")
	private String email;

	@Column(name = "Employee_Salary")
	private double salary;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Department_Id", nullable = false)
	private DepartmentEntity deptt;
}