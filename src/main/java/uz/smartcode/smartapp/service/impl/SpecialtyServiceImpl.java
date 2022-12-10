package uz.smartcode.smartapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.smartcode.smartapp.dao.SpecialtyRepository;
import uz.smartcode.smartapp.entity.Specialty;
import uz.smartcode.smartapp.service.SpecialtyService;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {
    private final SpecialtyRepository repository;

    @Autowired
    public SpecialtyServiceImpl(SpecialtyRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<?> getAll() {
        return ok(repository.findAll());
    }

    @Override
    public ResponseEntity<?> getOne(Integer id) {
        Optional<Specialty> optionalSpecialty = repository.findById(id);
        if (!optionalSpecialty.isPresent()) return notFound().build();
        return ok(optionalSpecialty.get());
    }

    @Override
    public ResponseEntity<?> addSpecialty(Specialty specialty) {
        if (repository.existsByName(specialty.getName()))
            return status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        specialty.setId(null);
        return status(HttpStatus.CREATED).body(repository.save(specialty));
    }

    @Override
    public ResponseEntity<?> editSpecialty(Integer id, Specialty specialty) {
        Optional<Specialty> optionalSpecialty = repository.findById(id);
        if (!optionalSpecialty.isPresent()) return notFound().build();
        if (repository.existsByNameAndIdNot(specialty.getName(), id))
            return status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        specialty.setId(optionalSpecialty.get().getId());
        return status(HttpStatus.CREATED).body(repository.save(specialty));
    }

    @Override
    public ResponseEntity<?> deleteSpeciality(Integer id) {
        if (!repository.existsById(id))
            return notFound().build();
        try {
            repository.deleteById(id);
            return noContent().build();
        } catch (Exception e) {
            return badRequest().build();
        }
    }
}
