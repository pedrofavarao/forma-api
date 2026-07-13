package com.forma.api.infrastructure.dto.personalDto.request;

import com.forma.api.infrastructure.validator.ValidCref;
import jakarta.validation.constraints.Size;

public record PersonalResquestPatchDTO(

        @Size(min = 3, max = 100, message = "{validation.name.size}")
        String name,

        @ValidCref
        String cref) {

}
