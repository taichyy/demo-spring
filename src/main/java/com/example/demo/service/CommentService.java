package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.PostRepository;
import org.springframework.stereotype.Service;
import com.example.demo.repository.CommentRepository;

@Service
public class CommentService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    
    public CommentService(PostRepository postRepository, UserRepository userRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    public Comment createComment(Comment comment, Long postId, Long userId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        comment.setPost(post);
        comment.setUser(user);
        return commentRepository.save(comment);
    }
    
}
