package uz.smartcode.smartapp.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.smartcode.smartapp.controller.SpecialtyController;
import uz.smartcode.smartapp.entity.Specialty;
import uz.smartcode.smartapp.service.impl.SpecialtyServiceImpl;

@RestController
@RequestMapping("/api/specialty")
@CrossOrigin(origins = "*")
public class SpecialtyControllerImpl implements SpecialtyController {
    private final SpecialtyServiceImpl service;

    @Autowired
    public SpecialtyControllerImpl(SpecialtyServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    @Override
    public ResponseEntity<?> getSpecialties() {
        return service.getAll();
    }

    @GetMapping("/{specialtyId}")
    @Override
    public ResponseEntity<?> getSpecialty(@PathVariable("specialtyId") Integer id) {
        return service.getOne(id);
    }

    @PostMapping
    @Override
    public ResponseEntity<?> saveSpecialty(@RequestBody Specialty specialty) {
        return service.addSpecialty(specialty);
    }

    @PutMapping("/{specialtyId}")
    @Override
    public ResponseEntity<?> updateSpecialty(@PathVariable("specialtyId") Integer id, @RequestBody Specialty specialty) {
        return service.editSpecialty(id, specialty);
    }

    @DeleteMapping("/{specialtyId}")
    @Override
    public ResponseEntity<?> deleteSpecialty(@PathVariable("specialtyId") Integer id) {
        return service.deleteSpeciality(id);
    }
}
