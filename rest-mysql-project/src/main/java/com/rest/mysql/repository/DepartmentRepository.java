package com.rest.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.mysql.model.DepartmentEntity;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

}
