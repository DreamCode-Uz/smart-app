package uz.smartcode.smartapp.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.smartcode.smartapp.controller.LevelController;
import uz.smartcode.smartapp.entity.Level;
import uz.smartcode.smartapp.service.impl.LevelServiceImpl;

@RestController
@RequestMapping("/api/level")
@CrossOrigin(origins = "*")
public class LevelControllerImpl implements LevelController {

    private final LevelServiceImpl service;

    @Autowired
    public LevelControllerImpl(LevelServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    @Override
    public ResponseEntity<?> getLevels() {
        return service.getAll();
    }

    @GetMapping("/{levelId}")
    @Override
    public ResponseEntity<?> getLevel(@PathVariable Integer levelId) {
        return service.getOne(levelId);
    }

    @PostMapping
    @Override
    public ResponseEntity<?> addLevel(@RequestBody Level level) {
        return service.addLevel(level);
    }

    @PutMapping("/{levelId}")
    @Override
    public ResponseEntity<?> editLevel(@PathVariable Integer levelId, @RequestBody Level level) {
        return service.editLevel(levelId, level);
    }

    @DeleteMapping("/{levelId}")
    @Override
    public ResponseEntity<?> deleteLevel(@PathVariable Integer levelId) {
        return service.deleteLevel(levelId);
    }
}
