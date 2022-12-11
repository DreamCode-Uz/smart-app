package uz.smartcode.smartapp.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface AttachmentService {
    ResponseEntity<?> getAttachment(UUID fileId);

    ResponseEntity<?> saveAttachment(MultipartFile file);

    ResponseEntity<?> downloadAttachment(UUID fileId);

    ResponseEntity<?> deleteAttachment(UUID fileId);
}
