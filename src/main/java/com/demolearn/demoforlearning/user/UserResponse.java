package com.demolearn.demoforlearning.user;

import java.time.Instant;

public record UserResponse(int id, String name, String emailId, String password, Long phone, Instant dateOfBirth, String gender) {}
