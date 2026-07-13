package com.forma.api.infrastructure.dto.userDto.response;

import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String username,
        String email
) {
}
