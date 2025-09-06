package com.demolearn.demoforlearning.user;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

	private final UserRepository userRepository;
	
	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public UserServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	@Override
	public UserResponse addUser(UserRequest userReq) {
		
		logger.info("userReq values: {}", userReq);
		User user = User.fromRequest(userReq);
		logger.info("userReq from request values: {}", userReq);
		user.setPassword(passwordEncoder.encode(userReq.password()));
		user.setConfirmPassword(passwordEncoder.encode(userReq.confirmPassword()));
		logger.info("userReq from request for saving values: {}", userReq);
		return userRepository.save(user).toResponse();
	}

	@Override
	public List<User> allUsers() {
		return userRepository.findAll();
	}

	@Override
	public UserResponse updateUser(int id, UserRequest userReq) {
		// TODO Auto-generated method stub
		Optional<User> optionalUser = userRepository.findById(id);
		logger.info("loger id: {}", optionalUser.get());
		if(optionalUser.isEmpty()) {
			throw new RuntimeException("user not found");
		}
		User user = optionalUser.get();
		user.updateUser(userReq);
		logger.info("loger UserReq: {}", userReq);
		User updatedUser = userRepository.save(user);
		return updatedUser.toResponse();
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}
	
	

}
