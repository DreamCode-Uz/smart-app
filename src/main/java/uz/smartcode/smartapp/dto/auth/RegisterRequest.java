package uz.smartcode.smartapp.dto.auth;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class RegisterRequest implements Serializable {
    @NotNull
    @Size(min = 4, max = 60)
    private final String username;
    @NotNull
    private final String firstname;
    private final String lastname;
    @NotNull
    @Email
    private final String email;
    @NotNull
    @Size(min = 7)
    private final String password;
}
