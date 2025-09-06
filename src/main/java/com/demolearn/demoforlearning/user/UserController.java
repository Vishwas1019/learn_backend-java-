package com.demolearn.demoforlearning.user;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest useReq) {
		UserResponse userResponse = userService.addUser(useReq);
		return ResponseEntity.ok(userResponse);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> allUser() {
		return ResponseEntity.ok(userService.allUsers());
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<UserResponse> updateUser(@PathVariable int id, @RequestBody UserRequest userRequest) {
		
		UserResponse userResponse = userService.updateUser(id, userRequest);
		return ResponseEntity.ok(userResponse);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		 ResponseEntity.ok();
	}
	

}
