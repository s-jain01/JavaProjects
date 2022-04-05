package com.rest.mysql.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.rest.mysql.exception.ResourceNotFoundException;
import com.rest.mysql.model.Employee;
import com.rest.mysql.model.HighestPaidDepartmentDetails;
import com.rest.mysql.repository.EmployeeRepository;
import com.rest.mysql.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository repo;

	public EmployeeServiceImpl(EmployeeRepository repo) {
		this.repo = repo;
	}

	@Override
	public Employee saveEmployeeRecord(Employee employee) {
		return repo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee existingEmployee = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));

		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setDepttId(employee.getDepttId());
		existingEmployee.setSalary(employee.getSalary());
		repo.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		repo.deleteById(id);
	}

	@Override
	public HighestPaidDepartmentDetails getHighestPaidDepartmentInfo() {
		HighestPaidDepartmentDetails highestPaidDepartmentDetails = new HighestPaidDepartmentDetails();
		List<Employee> employeesList = repo.findAll();
		HashMap<String, Double> depttMap = new HashMap<>();
		for (Employee emp : employeesList) {
			if (depttMap.get(emp.getDepttId()) != null) {
				depttMap.put(emp.getDepttId(), depttMap.get(emp.getDepttId()) + emp.getSalary());
			} else {
				depttMap.put(emp.getDepttId(), emp.getSalary());
			}
		}

		Entry<String, Double> highestPaidDepttEntry = findHighestPaidDepttId(depttMap);
		Long totalEmployeesUnderSpecifiedDeptt = employeesList.stream()
				.filter(e -> e.getDepttId().equalsIgnoreCase(highestPaidDepttEntry.getKey())).count();
		highestPaidDepartmentDetails.setDepartmentId(highestPaidDepttEntry.getKey());
		highestPaidDepartmentDetails.setTotalSalary(highestPaidDepttEntry.getValue());
		highestPaidDepartmentDetails.setTotalEmployees(totalEmployeesUnderSpecifiedDeptt);

		return highestPaidDepartmentDetails;
	}

	public <K, V extends Comparable<V>> Entry<K, V> findHighestPaidDepttId(Map<K, V> map) {
		Entry<K, V> maxEntry = Collections.max(map.entrySet(), new Comparator<Entry<K, V>>() {
			public int compare(Entry<K, V> e1, Entry<K, V> e2) {
				return e1.getValue().compareTo(e2.getValue());
			}
		});
		return maxEntry;
	}
}
