package uz.smartcode.smartapp.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.smartcode.smartapp.service.impl.AttachmentServiceImpl;

import java.util.UUID;

@RestController
@RequestMapping("/api/file")
public class AttachmentController {
    private final AttachmentServiceImpl service;

    @Autowired
    public AttachmentController(AttachmentServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{fileId}")
    public ResponseEntity<?> getOne(@PathVariable("fileId") UUID fileId) {
        return service.getAttachment(fileId);
    }

    @PostMapping
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        return service.saveAttachment(file);
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<?> downloadFile(@PathVariable("fileId") UUID fileId) {
        return service.downloadAttachment(fileId);
    }

    @DeleteMapping("/{fileId}")
    public ResponseEntity<?> deleteFile(@PathVariable("fileId") UUID fileId) {
        return service.deleteAttachment(fileId);
    }
}
