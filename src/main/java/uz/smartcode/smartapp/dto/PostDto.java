package uz.smartcode.smartapp.dto;

import lombok.Data;
import uz.smartcode.smartapp.entity.Tag;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

/**
 * A DTO for the {@link uz.smartcode.smartapp.entity.Post} entity
 */
@Data
public class PostDto implements Serializable {
    @NotNull
    private final String title;
    @NotNull
    private final String content;
    private final Set<Integer> tags;
    @NotNull
    private UUID userId;
}