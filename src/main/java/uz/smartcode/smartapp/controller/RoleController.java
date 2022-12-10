package uz.smartcode.smartapp.controller;

import org.springframework.http.ResponseEntity;

public interface RoleController {
    ResponseEntity<?> getRoles();

    ResponseEntity<?> getRole(Integer roleId);
}
