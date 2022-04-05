package com.rest.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.mysql.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
