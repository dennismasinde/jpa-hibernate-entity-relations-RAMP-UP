package io.maddennis.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * DTO for {@link io.maddennis.entity.User}
 */
@AllArgsConstructor
@Getter
@ToString
public record UserLoginRequestDto(
        @Email String email,
        @NotNull @NotEmpty @NotBlank String password)
        implements Serializable {
}