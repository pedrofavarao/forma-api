package com.forma.api.infrastructure.requestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record UserPatchDTO(
        @Email(message = "validation.user.email.invalid")
        String email,
        @Size(min = 3, max = 50, message = "{validation.user.username.size}")
        String username,
        @Size(min = 8, max = 255, message = "{validation.user.password.size}")
        String password) {

}
