package uz.smartcode.smartapp.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.smartcode.smartapp.controller.PostController;
import uz.smartcode.smartapp.dto.PostDto;
import uz.smartcode.smartapp.service.impl.PostServiceImpl;

import java.util.UUID;

@RestController
@RequestMapping("/api/post")
@CrossOrigin(origins = "*")
public class PostControllerImpl implements PostController {
    private final PostServiceImpl service;

    @Autowired
    public PostControllerImpl(PostServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/user/{userId}")
    @Override
    public ResponseEntity<?> getUserPosts(@PathVariable("userId") UUID userId, @RequestParam(name = "sort", defaultValue = "id") String sortBy) {
        return service.getUserPosts(userId, sortBy);
    }

    @GetMapping
    @Override
    public ResponseEntity<?> getAllPosts(
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "size", defaultValue = "10") Integer size,
            @RequestParam(name = "sort", defaultValue = "id") String sortBy
    ) {
        return service.getAllPosts(page, size, sortBy);
    }

    @GetMapping("/{postId}")
    @Override
    public ResponseEntity<?> getPost(@PathVariable("postId") UUID postId) {
        return service.getPost(postId);
    }

    @PostMapping
    @Override
    public ResponseEntity<?> savePost(@RequestBody PostDto dto) {
        return service.addPost(dto);
    }

    @PutMapping("/{postId}")
    @Override
    public ResponseEntity<?> editPost(@PathVariable UUID postId,@RequestBody PostDto dto) {
        return service.editPost(postId, dto);
    }

    @DeleteMapping("/{postId}")
    @Override
    public ResponseEntity<?> deletePost(@PathVariable("postId") UUID postId) {
        return service.deletePost(postId);
    }
}
