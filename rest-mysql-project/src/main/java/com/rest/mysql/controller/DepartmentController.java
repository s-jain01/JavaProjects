package com.rest.mysql.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.mysql.model.DepartmentEntity;
import com.rest.mysql.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
	private DepartmentService departmentService;
	
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveDepttDetails(@RequestBody DepartmentEntity departmentEntity){
		departmentService.saveDepartmentDetails(departmentEntity);
		return new ResponseEntity<String>("Details saved successfully!.", HttpStatus.CREATED);
	}
}
