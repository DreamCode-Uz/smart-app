package uz.smartcode.smartapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.smartcode.smartapp.entity.AttachmentContent;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Integer> {
    Optional<AttachmentContent> findByAttachment_Id(UUID attachment_id);
}