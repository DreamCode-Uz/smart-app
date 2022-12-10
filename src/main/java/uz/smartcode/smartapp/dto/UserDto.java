package uz.smartcode.smartapp.dto;

import lombok.Data;
import uz.smartcode.smartapp.entity.Social;
import uz.smartcode.smartapp.entity.User;

import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link User} entity
 */
@Data
public class UserDto implements Serializable {
    private final String username;
    private final String firstname;
    private final String lastname;
    private final String email;
    private final String enabled;
    private final Integer levelId;
    private final Integer specialtyId;
    private final String password;
}