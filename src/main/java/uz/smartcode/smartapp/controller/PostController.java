package uz.smartcode.smartapp.controller;

import org.springframework.http.ResponseEntity;
import uz.smartcode.smartapp.dto.PostDto;

import java.io.Serializable;
import java.util.UUID;

public interface PostController extends Serializable {
    ResponseEntity<?> getUserPosts(UUID userId, String sortBy);

    ResponseEntity<?> getAllPosts(Integer page, Integer size, String sortBy);

    ResponseEntity<?> getPost(UUID postId);

    ResponseEntity<?> savePost(PostDto dto);

    ResponseEntity<?> editPost(UUID postId, PostDto dto);

    ResponseEntity<?> deletePost(UUID postId);
}
