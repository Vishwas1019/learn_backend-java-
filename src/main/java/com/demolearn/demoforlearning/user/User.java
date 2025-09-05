package com.demolearn.demoforlearning.user;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private String emailId;
	
	private String password;
	
	private String confirmPassword;
	
	private Long phone;
	
	private Instant dateOfBirth;
	
	private String gender;

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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Instant getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Instant dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public static User fromRequest(UserRequest request) {
		var entity = new User();
		entity.setName(request.name());
		entity.setEmailId(request.emailId());
		entity.setPassword(request.password());
		entity.setConfirmPassword(request.confirmPassword());
		entity.setPhone(request.phone());
		entity.setDateOfBirth(request.dateOfBirth());
		entity.setGender(request.gender());
		return entity;
		
	}
	
	public UserResponse toResponse() {
		return new UserResponse(this.getId(), this.getName(), this.getEmailId(), this.getPassword(), this.getPhone(), this.getDateOfBirth(), this.getGender());
	}
	
	public void updateUser(UserRequest request) {
		this.setName(request.name());
		this.setEmailId(request.emailId());
		this.setPassword(request.password());
		this.setConfirmPassword(request.confirmPassword());
		this.setPhone(request.phone());
		this.setDateOfBirth(request.dateOfBirth());
		this.setGender(request.gender());
	}
	
	
}
