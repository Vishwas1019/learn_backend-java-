package com.demolearn.demoforlearning.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private String department;
	
	private Double salary;

	/*
	 * public EmployeeEntity(int id, String name, String department, Long salary) {
	 * super(); this.id = id; this.name = name; this.department = department;
	 * this.salary = salary; }
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	

public static EmployeeEntity fromRequest(EmployeeEntityRequest request) {
	var entity = new EmployeeEntity();
	entity.setName(request.name());
	entity.setDepartment(request.departmentname());
	entity.setSalary(request.salary());
	return entity;
}
	
public EmployeeResponse toResponse() {
	return new EmployeeResponse(
			this.getId(),
			this.getName(),
			this.getDepartment(),
			this.getSalary()
			);
}
	
	

}
