package uz.smartcode.smartapp.service;

import org.springframework.http.ResponseEntity;
import uz.smartcode.smartapp.entity.Tag;

public interface TagService {
    ResponseEntity<?> getAll();

    ResponseEntity<?> getOne(Integer tagId);

    ResponseEntity<?> addTag(Tag tag);

    ResponseEntity<?> editTag(Integer tagId, Tag tag);

    ResponseEntity<?> deleteTag(Integer tagId);
}
