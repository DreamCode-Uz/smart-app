package uz.smartcode.smartapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sun.plugin2.util.SystemUtil;
import uz.smartcode.smartapp.dao.AttachmentContentRepository;
import uz.smartcode.smartapp.dao.AttachmentRepository;
import uz.smartcode.smartapp.dto.response.AttachmentResponse;
import uz.smartcode.smartapp.entity.Attachment;
import uz.smartcode.smartapp.entity.AttachmentContent;
import uz.smartcode.smartapp.service.AttachmentService;

import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.ResponseEntity.*;
import static org.springframework.http.ResponseEntity.ok;

@Service
public class AttachmentServiceImpl implements AttachmentService {
    private final AttachmentRepository attachmentRepository;
    private final AttachmentContentRepository contentRepository;

    @Autowired
    public AttachmentServiceImpl(AttachmentRepository attachmentRepository, AttachmentContentRepository contentRepository) {
        this.attachmentRepository = attachmentRepository;
        this.contentRepository = contentRepository;
    }

    @Override
    public ResponseEntity<?> getAttachment(UUID fileId) {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(fileId);
        if (!optionalAttachment.isPresent()) return status(NOT_FOUND).body("The file does not exist");
        String downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/file/download/")
                .path(fileId.toString())
                .toUriString();
        return ok(new AttachmentResponse(optionalAttachment.get(), downloadUrl));
    }

    @Override
    public ResponseEntity<?> saveAttachment(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) return badRequest().body("Filename contains invalid path sequence");
            Attachment attachment = new Attachment(fileName, file.getContentType(), file.getSize());
            AttachmentContent content = new AttachmentContent();
            attachment.setContent(content);
            content.setBytes(file.getBytes());
            content.setAttachment(attachment);
            AttachmentContent savedAttachment = contentRepository.save(content);
            String downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/file/download/")
                    .path(savedAttachment.getAttachment().getId().toString())
                    .toUriString();
            return ok(new AttachmentResponse(savedAttachment.getAttachment(), downloadUrl));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return badRequest().build();
        }
    }

    @Override
    public ResponseEntity<?> downloadAttachment(UUID fileId) {
        Optional<AttachmentContent> optionalAttachmentContent = contentRepository.findByAttachment_Id(fileId);
        if (!optionalAttachmentContent.isPresent()) return notFound().build();
        Attachment attachment = optionalAttachmentContent.get().getAttachment();
        return ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + attachment.getFileName() + "\"")
                .contentType(MediaType.parseMediaType(attachment.getFileType()))
                .body(new ByteArrayResource(optionalAttachmentContent.get().getBytes()));
    }

    @Override
    public ResponseEntity<?> deleteAttachment(UUID fileId) {
        return null;
    }
}
