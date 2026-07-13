package com.forma.api.infrastructure.dto.personalDto.request;

import com.forma.api.infrastructure.validator.ValidCref;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PersonalRequestUpdateDTO(
        @NotBlank(message = "{validation.name.required}")
        @Size(min = 3, max = 100, message = "{validation.name.size}")
        String name,

        @NotBlank(message = "{validation.cref.required}")
        @ValidCref
        String cref
) {
}
