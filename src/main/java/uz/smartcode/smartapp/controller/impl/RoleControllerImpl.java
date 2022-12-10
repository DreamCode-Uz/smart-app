package uz.smartcode.smartapp.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.smartcode.smartapp.controller.RoleController;
import uz.smartcode.smartapp.service.impl.RoleServiceImpl;

@RestController
@RequestMapping(value = "/api/role", produces = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = "*")
public class RoleControllerImpl implements RoleController {

    private final RoleServiceImpl service;

    @Autowired
    public RoleControllerImpl(RoleServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    @Override
    public ResponseEntity<?> getRoles() {
        return service.getAll();
    }

    @GetMapping("/{roleId}")
    @Override
    public ResponseEntity<?> getRole(@PathVariable Integer roleId) {
        return service.getOne(roleId);
    }
}
