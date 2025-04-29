package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.JwtUtil;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class TokenService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public TokenService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    // 登入並生成 JWT
    public String login(String phone, String password) {
        // 先檢查用戶是否存在
        User user = userRepository.findByPhone(phone).orElse(null);
        
        if (user != null && verifyPassword(password, user.getPassword(), user.getSalt())) {
            // 如果用戶存在並且密碼匹配，生成 JWT
            return jwtUtil.generateToken(user);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

    // 驗證密碼是否正確
    private boolean verifyPassword(String password, String storedPassword, String salt) {
        String hashedPassword = hashPassword(password, salt);
        return storedPassword.equals(hashedPassword);
    }

    // 密碼哈希化處理
    private String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update((password + salt).getBytes());
            byte[] digest = md.digest();
            return bytesToHex(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
