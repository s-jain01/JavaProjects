package com.rest.mysql.object.to;

import lombok.Data;

@Data
public class HighestPaidDepartmentDetails {
	private double totalSalary;
	private long totalEmployees;
	private long departmentId;
}
