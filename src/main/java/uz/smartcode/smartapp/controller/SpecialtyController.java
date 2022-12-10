package uz.smartcode.smartapp.controller;

import org.springframework.http.ResponseEntity;
import uz.smartcode.smartapp.entity.Specialty;

public interface SpecialtyController {
    ResponseEntity<?> getSpecialties();

    ResponseEntity<?> getSpecialty(Integer id);

    ResponseEntity<?> saveSpecialty(Specialty specialty);

    ResponseEntity<?> updateSpecialty(Integer id, Specialty specialty);

    ResponseEntity<?> deleteSpecialty(Integer id);
}
