package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.APIResponse;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    private final UserService authService;

    public UserController(UserService authService) {
        this.authService = authService;
    }

    @PostMapping("/user")
    public APIResponse<Object> register(@RequestBody User user) {
        Object body = authService.register(user.getPhone(), user.getPassword());
    
        return new APIResponse<>(200, "User created successfully.", body);
    }
}
