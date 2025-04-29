package com.example.demo.controller;

import com.example.demo.model.APIResponse;
import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import com.example.demo.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;
    private final JwtUtil jwtUtil;

    public PostController(PostService postService, JwtUtil jwtUtil) {
        this.postService = postService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping
    public APIResponse<Object> getAllPosts() {
        Object body = postService.getAllPosts();
        return new APIResponse<>(200, "Posts retrieved successfully.", body);
    }

    @PostMapping
    public APIResponse<Object> createPost(@RequestBody Post post, HttpServletRequest request) {
        String token = jwtUtil.extractTokenFromHeader(request);
        // Extract userId from token.
        Long userId = jwtUtil.extractUserId(token); 

        Post savedPost = postService.createPost(post, userId);
        return new APIResponse<>(201, "Post created successfully.", savedPost);
    }

    @PutMapping("/{postId}")
    public APIResponse<Object> updatePost(@PathVariable Long postId, @RequestBody Post updatedPost) {
        Post post = postService.updatePost(postId, updatedPost);
        return new APIResponse<>(200, "Post updated successfully.", post);
    }

    @DeleteMapping("/{postId}")
    public APIResponse<Object> deletePost(@PathVariable Long postId) {
        Post deletedPost = postService.deletePost(postId);
        return new APIResponse<>(200, "Post deleted successfully.", deletedPost);
    }
}
