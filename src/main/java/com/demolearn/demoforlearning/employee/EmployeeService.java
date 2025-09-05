package com.demolearn.demoforlearning.employee;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

	EmployeeResponse addEmployee(EmployeeEntityRequest request);
}
