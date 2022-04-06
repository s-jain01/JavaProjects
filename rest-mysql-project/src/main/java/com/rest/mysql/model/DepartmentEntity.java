package com.rest.mysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "department") // without this annotation table created with the default name "department_entity"
public class DepartmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Deptt_Id")
	private long departmentId;

	@Column(name = "Deptt_Name")
	private String departmentName;

	@Column(name = "Deptt_Block_Name")
	private String departmentUnderBlock;
}
