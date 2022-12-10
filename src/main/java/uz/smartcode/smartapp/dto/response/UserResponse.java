package uz.smartcode.smartapp.dto.response;

import lombok.Data;
import uz.smartcode.smartapp.entity.Role;
import uz.smartcode.smartapp.entity.User;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Data
public class UserResponse {
    private final UUID id;
    private final String firstname;
    private final String lastname;
    private final String username;
    private final String email;
    private final String bio;
    private final Timestamp createdAt;
    private final Timestamp updatedAt;
    private final UUID createdBy;
    private final UUID updatedBy;
    private final Set<Role> roles;

    public UserResponse(User user) {
        this.id = user.getId();
        this.firstname = user.getFirstName();
        this.lastname = user.getLastName();
        this.username = user.getUsername();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
        this.createdBy = user.getCreatedBy();
        this.updatedBy = user.getUpdatedBy();
        this.email = user.getEmail();
        this.roles = user.getRole();
        this.bio = user.getBio();
    }
}
