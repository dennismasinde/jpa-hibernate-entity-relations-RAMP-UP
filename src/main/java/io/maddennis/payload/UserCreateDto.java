package io.maddennis.payload;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * DTO for {@link io.maddennis.entity.User}
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserCreateDto implements Serializable {
    private final String firstName;
    private final String lastName;
    @Email
    private final String email;
    private final String password;
    private final String phone;
}