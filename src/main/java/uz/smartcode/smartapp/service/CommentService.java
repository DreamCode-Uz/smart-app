package uz.smartcode.smartapp.service;

import org.springframework.http.ResponseEntity;
import uz.smartcode.smartapp.dto.CommentDto;

import java.util.UUID;

public interface CommentService {
    /**
     * @param page
     * @param size
     * */
    ResponseEntity<?> getAll(Integer page, Integer size);

    /**
     * @param commentId UUID
     * */
    ResponseEntity<?> getOne(UUID commentId);

    /**
     * @param dto {{@link CommentDto}}
     * */
    ResponseEntity<?> addComment(CommentDto dto);

    ResponseEntity<?> editComment(CommentDto dto);

    ResponseEntity<?> deleteComment(Integer commentId);
}
