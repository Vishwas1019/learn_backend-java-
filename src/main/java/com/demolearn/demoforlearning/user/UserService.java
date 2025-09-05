package com.demolearn.demoforlearning.user;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {

	UserResponse addUser(UserRequest userReq);
	
	List<User> allUsers();
	
	UserResponse updateUser(int id, UserRequest userReq);
	
	void deleteUser(int id);
}
