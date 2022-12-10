package uz.smartcode.smartapp.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CommentDto {
    private final String content;
    private final UUID postId;
    private final Integer commentId;
}
