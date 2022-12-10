package uz.smartcode.smartapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.smartcode.smartapp.dao.TagRepository;
import uz.smartcode.smartapp.entity.Tag;
import uz.smartcode.smartapp.service.TagService;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@Service
public class TagServiceImpl implements TagService {
    private final TagRepository repository;

    @Autowired
    public TagServiceImpl(TagRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<?> getAll() {
        return ok(repository.findAll());
    }

    @Override
    public ResponseEntity<?> getOne(Integer tagId) {
        Optional<Tag> optionalTag = repository.findById(tagId);
        if (optionalTag.isPresent()) return ok(optionalTag.get());
        return notFound().build();
    }

    @Override
    public ResponseEntity<?> addTag(Tag tag) {
        if (repository.existsByName(tag.getName()))
            return status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        return status(HttpStatus.CREATED).body(repository.save(tag));
    }

    @Override
    public ResponseEntity<?> editTag(Integer tagId, Tag tag) {
        Optional<Tag> optionalTag = repository.findById(tagId);
        if (!optionalTag.isPresent()) return notFound().build();
        if (repository.existsByNameAndIdNot(tag.getName(), tagId))
            return status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        tag.setId(optionalTag.get().getId());
        return status(HttpStatus.CREATED).body(repository.save(tag));
    }

    @Override
    public ResponseEntity<?> deleteTag(Integer tagId) {
        Optional<Tag> optionalTag = repository.findById(tagId);
        if (optionalTag.isPresent()) {
            try {
                repository.delete(optionalTag.get());
                return noContent().build();
            } catch (Exception e) {
                return badRequest().build();
            }
        }
        return notFound().build();
    }
}
