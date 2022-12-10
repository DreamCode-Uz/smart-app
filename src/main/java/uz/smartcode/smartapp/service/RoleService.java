package uz.smartcode.smartapp.service;

import org.springframework.http.ResponseEntity;

public interface RoleService {

    ResponseEntity<?> getAll();

    ResponseEntity<?> getOne(Integer roleId);
}
