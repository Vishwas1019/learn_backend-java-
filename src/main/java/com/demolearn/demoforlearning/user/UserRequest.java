package com.demolearn.demoforlearning.user;

import java.time.Instant;

public record UserRequest(String name, String emailId, String password, String confirmPassword, Long phone, Instant dateOfBirth, String gender) {}
