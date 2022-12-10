package uz.smartcode.smartapp.controller;

import org.springframework.http.ResponseEntity;
import uz.smartcode.smartapp.entity.Level;

public interface LevelController {
    ResponseEntity<?> getLevels();

    ResponseEntity<?> getLevel(Integer levelId);

    ResponseEntity<?> addLevel(Level level);

    ResponseEntity<?> editLevel(Integer levelId, Level level);

    ResponseEntity<?> deleteLevel(Integer levelId);
}
