package uz.smartcode.smartapp.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.smartcode.smartapp.controller.UserController;
import uz.smartcode.smartapp.dto.UserDto;
import uz.smartcode.smartapp.service.impl.UserServiceImpl;

import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserControllerImpl implements UserController {
    private final UserServiceImpl service;

    @Autowired
    public UserControllerImpl(UserServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    @Override
    public ResponseEntity<?> getAll(@RequestParam(name = "page", defaultValue = "1") Integer page, @RequestParam(name = "size", defaultValue = "10") Integer size) {
        return service.getUsers(page, size);
    }

    @GetMapping("/{userId}")
    @Override
    public ResponseEntity<?> getOne(@PathVariable UUID userId) {
        return service.getUser(userId);
    }

    @PostMapping
    @Override
    public ResponseEntity<?> saveUser(@RequestBody UserDto dto) {
        return service.addUser(dto);
    }

    @PutMapping("/{userId}")
    @Override
    public ResponseEntity<?> updateUser(@PathVariable UUID userId, @RequestBody UserDto dto) {
        return service.editUser(userId, dto);
    }

    @DeleteMapping("/{userId}")
    @Override
    public ResponseEntity<?> deleteUser(@PathVariable UUID userId) {
        return service.deleteUser(userId);
    }

    @PostMapping("/{userId}/block/{isLocked}")
    @Override
    public ResponseEntity<?> blockUser(@PathVariable("userId") UUID userId,@PathVariable("isLocked") boolean status) {
        return service.userDeactivate(userId, status);
    }

    @GetMapping("/block")
    @Override
    public ResponseEntity<?> getBlockUsers() {
        return service.getBlockUsers();
    }
}
