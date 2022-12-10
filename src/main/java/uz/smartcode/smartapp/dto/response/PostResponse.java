package uz.smartcode.smartapp.dto.response;

import lombok.Data;
import uz.smartcode.smartapp.entity.Post;
import uz.smartcode.smartapp.entity.Tag;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Data
public class PostResponse {
    private final UUID postId;
    private final String title;
    private final String content;
    private final UUID userId;
    private final Set<Tag> tags;
    private final Timestamp createdAt;
    private final Timestamp updatedAt;
    private final Timestamp publishedAt;

    public PostResponse(Post post) {
        this.postId = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.userId = post.getAuthor().getId();
        this.tags = post.getTags();
        this.createdAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();
        this.publishedAt = post.getPublishedAt();
    }
}
