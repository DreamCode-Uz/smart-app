package uz.smartcode.smartapp.service;

import org.springframework.http.ResponseEntity;
import uz.smartcode.smartapp.entity.Level;

public interface LevelService {
    ResponseEntity<?> getAll();

    ResponseEntity<?> getOne(Integer levelId);

    ResponseEntity<?> addLevel(Level level);

    ResponseEntity<?> editLevel(Integer levelId, Level level);

    ResponseEntity<?> deleteLevel(Integer levelId);
}
