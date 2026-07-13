package com.forma.api.infrastructure.dto.personalDto.request;

import com.forma.api.infrastructure.dto.userDto.request.UserRequestDTO;
import com.forma.api.infrastructure.validator.ValidCref;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PersonalRequestCreateDTO(
        @NotNull(message = "{validation.user.required}")
        @Valid
        UserRequestDTO user,

        @NotBlank(message = "{validation.name.required}")
        @Size(min = 3, max = 100, message = "{validation.name.size}")
        String name,

        @NotBlank(message = "{validation.cref.required}")
        @ValidCref
        String cref
) {
}
