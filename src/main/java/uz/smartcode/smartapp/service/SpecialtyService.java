package uz.smartcode.smartapp.service;

import org.springframework.http.ResponseEntity;
import uz.smartcode.smartapp.entity.Specialty;

public interface SpecialtyService {
    ResponseEntity<?> getAll();

    ResponseEntity<?> getOne(Integer id);

    ResponseEntity<?> addSpecialty(Specialty specialty);

    ResponseEntity<?> editSpecialty(Integer id, Specialty specialty);

    ResponseEntity<?> deleteSpeciality(Integer id);
}
