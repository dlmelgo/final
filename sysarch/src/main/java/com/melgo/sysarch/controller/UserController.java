package com.melgo.sysarch.controller;

import com.melgo.sysarch.dto.LoginRequest;
import com.melgo.sysarch.dto.SignUpRequest;
import com.melgo.sysarch.model.User;
import com.melgo.sysarch.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Sign up a new user", description = "Create a new user account with a username, password, email, and phone number.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User signed up successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input or existing username")
    })
    @PostMapping("/signup")
    public ResponseEntity<Object> signUp(@RequestBody SignUpRequest request) {
        try {
            User user = userService.signUp(request);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Log in a user", description = "Authenticate a user with email and password.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User logged in successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid credentials or user not found")
    })
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest request) {
        try {
            User user = userService.login(request);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
