package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.Post;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post createPost(Post post, Long userId) {
        User user = userRepository.findById(userId)
                        .orElseThrow(() -> new RuntimeException("User not found"));
    
        post.setUser(user); // 設定已存在的 user
        return postRepository.save(post);
    }

    public Post deletePost(Long postId) {
        Post post = postRepository.findById(postId)
                        .orElseThrow(() -> new RuntimeException("Post not found"));
        postRepository.delete(post);
        return post;
    }

    public Post updatePost(Long postId, Post updatedPost) {
        Post post = postRepository.findById(postId)
                        .orElseThrow(() -> new RuntimeException("Post not found"));
        post.setContent(updatedPost.getContent());
        post.setImage(updatedPost.getImage());
        return postRepository.save(post);
    }
}
