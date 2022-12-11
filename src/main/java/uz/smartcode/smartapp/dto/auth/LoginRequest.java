package uz.smartcode.smartapp.dto.auth;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class LoginRequest implements Serializable {
    @NotNull
    @Email
    private final String email;
    @NotNull
    @Size(min = 7)
    private final String password;
}
