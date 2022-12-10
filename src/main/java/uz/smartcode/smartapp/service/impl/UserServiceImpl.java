package uz.smartcode.smartapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.smartcode.smartapp.dao.RoleRepository;
import uz.smartcode.smartapp.dao.SocialRepository;
import uz.smartcode.smartapp.dao.UserRepository;
import uz.smartcode.smartapp.dto.UserDto;
import uz.smartcode.smartapp.dto.response.UserResponse;
import uz.smartcode.smartapp.entity.Role;
import uz.smartcode.smartapp.entity.User;
import uz.smartcode.smartapp.entity.enums.RoleName;
import uz.smartcode.smartapp.service.UserService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.*;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final SocialRepository socialRepository;

    @Autowired
    public UserServiceImpl(UserRepository repository, RoleRepository roleRepository, SocialRepository socialRepository) {
        this.repository = repository;
        this.roleRepository = roleRepository;
        this.socialRepository = socialRepository;
    }

    @Override
    public ResponseEntity<?> getUsers(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page > 0 ? page - 1 : 0, size > 0 ? size : 10);
        return ok(repository.findAll(pageRequest).map(UserResponse::new));
    }

    @Override
    public ResponseEntity<?> getUser(UUID userId) {
        Optional<User> optionalUser = repository.findById(userId);
        if (!optionalUser.isPresent()) return notFound().build();
        return ok(optionalUser.get());
    }

    @Override
    public ResponseEntity<?> getMe(UUID userId) {
        return null;
    }

    @Override
    public ResponseEntity<?> addUser(UserDto dto) {
        if (repository.existsByEmail(dto.getEmail())) return status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        if (repository.existsByUsername(dto.getUsername())) return status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        Role role = roleRepository.getRoleByName(RoleName.ROLE_USER);
        User user = new User(dto.getUsername(), dto.getFirstname(), dto.getLastname(), dto.getEmail(), Collections.singleton(role));
        user.setPassword(dto.getPassword());
        return status(HttpStatus.CREATED).body(repository.saveAndFlush(user));
    }

    @Override
    public ResponseEntity<?> editUser(UUID userId, UserDto dto) {
        Optional<User> optionalUser = repository.findById(userId);
        if (!optionalUser.isPresent()) return notFound().build();
        if (repository.existsByEmailAndIdNot(dto.getEmail(), userId))
            return status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        if (repository.existsByUsernameAndIdNot(dto.getUsername(), userId))
            return status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        User user = new User(userId, dto.getUsername(), dto.getFirstname(), dto.getLastname(), dto.getEmail(), true);
        return status(HttpStatus.CREATED).body(repository.save(user));
    }

    @Override
    public ResponseEntity<?> deleteUser(UUID userId) {
        Optional<User> optionalUser = repository.findById(userId);
        if (!optionalUser.isPresent()) return notFound().build();
        try {
            repository.delete(optionalUser.get());
            return noContent().build();
        } catch (Exception e) {
            return badRequest().build();
        }
    }

//    TODO user blocklangan paytda blocklangan user emailiga habar yuborish qo'shish kerak
    @Override
    public ResponseEntity<?> userDeactivate(UUID userId, boolean isLocked) {
        Optional<User> optionalUser = repository.findById(userId);
        if (!optionalUser.isPresent()) return notFound().build();
        User user = optionalUser.get();
        user.setAccountNonLocked(!isLocked);
        return status(HttpStatus.CREATED).body(repository.save(user));
    }

    @Override
    public ResponseEntity<?> getBlockUsers() {
        List<User> blockUsers = repository.findAllByAccountNonLocked(false);
        return ok(blockUsers.stream().map(UserResponse::new));
    }
}
