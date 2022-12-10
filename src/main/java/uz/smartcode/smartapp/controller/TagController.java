package uz.smartcode.smartapp.controller;

import org.springframework.http.ResponseEntity;
import uz.smartcode.smartapp.entity.Tag;

public interface TagController {
    ResponseEntity<?> getTags();

    ResponseEntity<?> getTag(Integer tagId);

    ResponseEntity<?> addTag(Tag tag);

    ResponseEntity<?> editTag(Integer tagId, Tag tag);

    ResponseEntity<?> deleteTag(Integer tagId);
}
