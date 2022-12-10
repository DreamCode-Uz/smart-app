package uz.smartcode.smartapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.smartcode.smartapp.dao.LevelRepository;
import uz.smartcode.smartapp.entity.Level;
import uz.smartcode.smartapp.service.LevelService;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@Service
public class LevelServiceImpl implements LevelService {
    private final LevelRepository repository;

    @Autowired
    public LevelServiceImpl(LevelRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<?> getAll() {
        return ok(repository.findAll());
    }

    @Override
    public ResponseEntity<?> getOne(Integer levelId) {
        Optional<Level> optionalLevel = repository.findById(levelId);
        if (optionalLevel.isPresent()) return ok(optionalLevel.get());
        return notFound().build();
    }

    @Override
    public ResponseEntity<?> addLevel(Level level) {
        if (repository.existsByName(level.getName())) return status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        return status(HttpStatus.CREATED).body(repository.save(level));
    }

    @Override
    public ResponseEntity<?> editLevel(Integer levelId, Level level) {
        Optional<Level> optionalLevel = repository.findById(levelId);
        if (!optionalLevel.isPresent()) return notFound().build();
        if (repository.existsByNameAndIdNot(level.getName(), levelId))
            return status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        Level l = optionalLevel.get();
        l.setName(level.getName());
        l.setStatus(level.isStatus());
        return status(HttpStatus.CREATED).body(repository.save(l));
    }

    @Override
    public ResponseEntity<?> deleteLevel(Integer levelId) {
        if (repository.existsById(levelId)) {
            try {
                repository.deleteById(levelId);
                return noContent().build();
            } catch (Exception e) {
                return badRequest().build();
            }
        }
        return notFound().build();
    }
}
