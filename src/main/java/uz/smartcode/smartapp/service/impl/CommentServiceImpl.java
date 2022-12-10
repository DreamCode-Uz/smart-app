package uz.smartcode.smartapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.smartcode.smartapp.dao.CommentRepository;
import uz.smartcode.smartapp.dto.CommentDto;
import uz.smartcode.smartapp.service.CommentService;

import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository repository;

    @Autowired
    public CommentServiceImpl(CommentRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<?> getAll(Integer page, Integer size) {
        return null;
    }

    @Override
    public ResponseEntity<?> getOne(UUID commentId) {
        return null;
    }

    @Override
    public ResponseEntity<?> addComment(CommentDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<?> editComment(CommentDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteComment(Integer commentId) {
        return null;
    }
}
