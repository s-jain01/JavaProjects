package com.rest.mysql.service;

import java.util.List;

import com.rest.mysql.model.Employee;
import com.rest.mysql.model.HighestPaidDepartmentDetails;

public interface EmployeeService {
	Employee saveEmployeeRecord(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee, long id);
	void deleteEmployee(long id);
	HighestPaidDepartmentDetails getHighestPaidDepartmentInfo();
}
