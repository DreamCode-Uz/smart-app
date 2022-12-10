package uz.smartcode.smartapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.smartcode.smartapp.dao.SocialRepository;
import uz.smartcode.smartapp.dao.UserRepository;
import uz.smartcode.smartapp.dto.SocialDto;
import uz.smartcode.smartapp.dto.response.SocialResponse;
import uz.smartcode.smartapp.entity.Social;
import uz.smartcode.smartapp.entity.User;
import uz.smartcode.smartapp.service.SocialService;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.*;

@Service
public class SocialServiceImpl implements SocialService {
    private final SocialRepository repository;
    private final UserRepository userRepository;

    @Autowired
    public SocialServiceImpl(SocialRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<?> getAll(UUID userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()) return notFound().build();
        return ok(optionalUser.get().getSocials().stream().map(SocialResponse::new));
    }

    @Override
    public ResponseEntity<?> getOne(Integer id) {
        Optional<Social> optionalSocial = repository.findById(id);
        if (!optionalSocial.isPresent()) return notFound().build();
        return ok(new SocialResponse(optionalSocial.get()));
    }

    @Override
    public ResponseEntity<?> addSocial(SocialDto dto) {
        Optional<User> optionalUser = userRepository.findById(dto.getUserId());
        if (!optionalUser.isPresent()) return notFound().build();
        Set<Social> socials = dto.getSocials();
        for (Social social : socials) {
            social.setUser(optionalUser.get());
        }
        return status(HttpStatus.CREATED).body(repository.saveAll(socials).stream().map(SocialResponse::new));
    }

    @Override
    public ResponseEntity<?> editSocial(Integer id, Social social) {
        Optional<Social> optionalSocial = repository.findById(id);
        if (!optionalSocial.isPresent()) return notFound().build();
        social.setId(id);
        return status(HttpStatus.CREATED).body(new SocialResponse(repository.save(social)));
    }

    @Override
    public ResponseEntity<?> deleteSocial(Integer id) {
        Optional<Social> optionalSocial = repository.findById(id);
        if (!optionalSocial.isPresent()) return notFound().build();
        repository.delete(optionalSocial.get());
        return noContent().build();
    }
}
