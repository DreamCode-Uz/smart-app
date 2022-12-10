package uz.smartcode.smartapp.service;

import org.springframework.http.ResponseEntity;
import uz.smartcode.smartapp.dto.PostDto;

import java.io.Serializable;
import java.util.UUID;

public interface PostService extends Serializable {
    ResponseEntity<?> getAllPosts(Integer page, Integer size, String sortBy);

    ResponseEntity<?> getUserPosts(UUID userId, String sortBy);

    ResponseEntity<?> getPost(UUID postId);

    ResponseEntity<?> addPost(PostDto dto);

    ResponseEntity<?> editPost(UUID postId, PostDto dto);

    ResponseEntity<?> deletePost(UUID postId);
}
