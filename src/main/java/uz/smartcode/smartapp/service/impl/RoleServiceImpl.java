package uz.smartcode.smartapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.smartcode.smartapp.dao.RoleRepository;
import uz.smartcode.smartapp.entity.Role;
import uz.smartcode.smartapp.service.RoleService;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    @Autowired
    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<?> getAll() {
        return ok(repository.findAll());
    }

    @Override
    public ResponseEntity<?> getOne(Integer roleId) {
        Optional<Role> optionalRole = repository.findById(roleId);
        if (optionalRole.isPresent()) return ok(optionalRole.get());
        return notFound().build();
    }
}
