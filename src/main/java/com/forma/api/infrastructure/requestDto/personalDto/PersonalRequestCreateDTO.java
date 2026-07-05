package com.forma.api.infrastructure.requestDto.personalDto;

import com.forma.api.infrastructure.requestDto.userDto.UserRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PersonalRequestCreateDTO(
        @NotNull(message = "{validation.user.required}")
        @Valid
        UserRequestDTO user,

        @NotBlank(message = "{validation.name.required}")
        @Size(min = 3, max = 100, message = "{validation.name.size}")
        String name,

        @NotBlank(message = "{validation.cref.required}")
        @Pattern(
                regexp = "^[0-9]{6,10}-[A-Z0-9]+$",
                message = "{validation.cref.pattern}"
        )
        String cref
) {
}
