package com.example.demo.controller;

import com.example.demo.model.APIResponse;
import com.example.demo.model.Comment;
import com.example.demo.service.CommentService;
import com.example.demo.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;
    private final JwtUtil jwtUtil;

    public CommentController(CommentService commentService, JwtUtil jwtUtil) {
        this.commentService = commentService;
        this.jwtUtil = jwtUtil;
    }

    @Data
    public static class CreateCommentRequest {
        private String content;
        private Long postId;
    }

    @PostMapping
    public APIResponse<Object> createComment(@RequestBody CreateCommentRequest requestBody, HttpServletRequest request) {
        String token = jwtUtil.extractTokenFromHeader(request);
        Long userId = jwtUtil.extractUserId(token);

        // 手動建構 Comment 實體（你也可以做成 mapper）
        Comment comment = new Comment();
        comment.setContent(requestBody.getContent());

        Comment savedComment = commentService.createComment(comment, requestBody.getPostId(), userId);
        return new APIResponse<>(201, "Comment created successfully.", savedComment);
    }
}
