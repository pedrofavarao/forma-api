package com.forma.api.infrastructure.requestDto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PersonalPatchDTO(

        @Size(min = 3, max = 100, message = "{validation.name.size}")
        String name,

        @Pattern(
                regexp = "^[0-9]{6,10}-[A-Z0-9]+$",
                message = "{validation.cref.pattern}"
        )
        String cref) {

}
