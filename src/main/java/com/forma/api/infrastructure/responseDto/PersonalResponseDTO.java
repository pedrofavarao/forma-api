package com.forma.api.infrastructure.responseDto;

import java.util.UUID;

public record PersonalResponseDTO(
        UUID id,
        String name,
        String cref,
        UserResponseDTO user
) {
}
