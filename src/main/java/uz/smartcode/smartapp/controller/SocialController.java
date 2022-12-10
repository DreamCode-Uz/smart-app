package uz.smartcode.smartapp.controller;

import org.springframework.http.ResponseEntity;
import uz.smartcode.smartapp.dto.SocialDto;
import uz.smartcode.smartapp.entity.Social;

import java.util.UUID;

public interface SocialController {
    ResponseEntity<?> getSocials(UUID userId);
    ResponseEntity<?> getSocial(Integer socialId);
    ResponseEntity<?> addSocials(SocialDto socialDto);
    ResponseEntity<?> editSocial(Integer socialId, Social social);
    ResponseEntity<?> deleteSocial(Integer socialId);
}
