package uz.smartcode.smartapp.dto.response;

import lombok.Data;
import uz.smartcode.smartapp.entity.Attachment;

import java.io.Serializable;

@Data
public class AttachmentResponse implements Serializable {
    private String fileName;
    private String fileType;
    private Long fileSize;
    private String downloadUrl;

    public AttachmentResponse(Attachment attachment) {
        this.fileName = attachment.getFileName();
        this.fileType = attachment.getFileType();
        this.fileSize = attachment.getFileSize();
    }

    public AttachmentResponse(Attachment attachment, String downloadUrl) {
        this.fileName = attachment.getFileName();
        this.fileType = attachment.getFileType();
        this.fileSize = attachment.getFileSize();
        this.downloadUrl = downloadUrl;
    }
}
