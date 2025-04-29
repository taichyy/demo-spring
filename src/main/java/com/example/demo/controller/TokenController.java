package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.APIResponse;
import com.example.demo.service.TokenService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class TokenController {
    private final TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    // POST /token 登入並返回 JWT
    @PostMapping("/token")
    public APIResponse<String> createToken(@RequestBody User user) {
        // 驗證用戶並生成 JWT
        String token = tokenService.login(user.getPhone(), user.getPassword());
    
        return new APIResponse<>(HttpStatus.OK.value(), "ok", token);
    }
}