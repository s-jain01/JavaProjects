package com.rest.mysql.service.impl;

import org.springframework.stereotype.Service;

import com.rest.mysql.model.DepartmentEntity;
import com.rest.mysql.repository.DepartmentRepository;
import com.rest.mysql.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentRepository repo;
	
	public DepartmentServiceImpl(DepartmentRepository repo) {
		this.repo = repo;
	}

	@Override
	public DepartmentEntity saveDepartmentDetails(DepartmentEntity departmentEntity) {
		return repo.save(departmentEntity);
	}

}
