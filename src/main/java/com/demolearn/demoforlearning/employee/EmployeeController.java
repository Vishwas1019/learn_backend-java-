package com.demolearn.demoforlearning.employee;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.demolearn.demoforlearning.employee.EmployeeService;

@RestController
public class EmployeeController{

	private final EmployeeService emplService;
	
	public EmployeeController(EmployeeService emplService) {
		this.emplService = emplService;
	}
	
	@PostMapping("addEmployee")
	public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody EmployeeEntityRequest request){
		EmployeeResponse addEmployee = emplService.addEmployee(request);
		return ResponseEntity.ok(addEmployee);
	}
}
