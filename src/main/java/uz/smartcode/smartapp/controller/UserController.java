package uz.smartcode.smartapp.controller;

import org.springframework.http.ResponseEntity;
import uz.smartcode.smartapp.dto.UserDto;

import java.util.UUID;

public interface UserController {
    ResponseEntity<?> getAll(Integer page, Integer size);

    ResponseEntity<?> getOne(UUID userId);

    ResponseEntity<?> saveUser(UserDto dto);

    ResponseEntity<?> updateUser(UUID userId, UserDto dto);

    ResponseEntity<?> deleteUser(UUID userId);

    ResponseEntity<?> blockUser(UUID userId, boolean status);

    ResponseEntity<?> getBlockUsers();
}
