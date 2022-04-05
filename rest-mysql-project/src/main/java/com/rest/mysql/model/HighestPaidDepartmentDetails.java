package com.rest.mysql.model;

import lombok.Data;

@Data
public class HighestPaidDepartmentDetails {
	private double totalSalary;
	private long totalEmployees;
	private String departmentId;
}
