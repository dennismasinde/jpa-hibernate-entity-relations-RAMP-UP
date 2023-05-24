package io.maddennis.payload;

import jakarta.validation.constraints.*;

import java.io.Serializable;

/**
 * DTO for {@link io.maddennis.entity.User}
 */
public record UserSignupRequestDto(
        @NotNull @NotEmpty @NotBlank String firstName,
        @NotNull @NotEmpty @NotBlank String lastName,
        @Email String email,
        String password,
        String phone) implements Serializable {
}