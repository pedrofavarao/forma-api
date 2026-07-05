package com.forma.api.infrastructure.requestDto.userDto;

import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String username,
        String email
) {
}
