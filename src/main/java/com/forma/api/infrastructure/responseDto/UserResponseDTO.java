package com.forma.api.infrastructure.responseDto;

import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String username,
        String email
) {
}
