package com.forma.api.infrastructure.dto.userDto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(

        @NotBlank(message = "{validation.user.username.required}")
        @Size(min = 3, max = 50, message = "{validation.user.username.size}")
        String username,

        @NotBlank(message = "{validation.user.email.required}")
        @Email(message = "{validation.user.email.invalid}")
        String email,

        @NotBlank(message = "{validation.user.password.required}")
        @Size(min = 8, max = 255, message = "{validation.user.password.size}")
        String password
) {
}