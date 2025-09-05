package com.demolearn.demoforlearning.employee;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeResponse addEmployee(EmployeeEntityRequest request) {
		// TODO Auto-generated method stub
		EmployeeEntity employee = EmployeeEntity.fromRequest(request);
		return employeeRepository.save(employee).toResponse();
	}

}
