package com.melgo.sysarch.service;

import com.melgo.sysarch.dto.LoginRequest;
import com.melgo.sysarch.dto.SignUpRequest;
import com.melgo.sysarch.model.User;
import com.melgo.sysarch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User signUp(SignUpRequest request) throws Exception {
        if (request.getUsername() == null || request.getPassword() == null ||
                request.getConfirmPassword() == null || request.getEmail() == null || request.getPhoneNumber() == null) {
            throw new Exception("All fields are required");
        }

        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new Exception("Passwords do not match");
        }

        Optional<User> existingUser = userRepository.findByUsername(request.getUsername());
        if (existingUser.isPresent()) {
            throw new Exception("Username already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());  // Store password as is (not recommended for production)
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());

        return userRepository.save(user);
    }

    public User login(LoginRequest request) throws Exception {
        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (request.getPassword().equals(user.getPassword())) {
                return user;
            } else {
                throw new Exception("Invalid credentials");
            }
        } else {
            throw new Exception("User not found");
        }
    }
}
