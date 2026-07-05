package com.forma.api.infrastructure.requestDto.personalDto;

import com.forma.api.infrastructure.requestDto.userDto.UserResponseDTO;

import java.util.UUID;

public record PersonalResponseDTO(
        UUID id,
        String name,
        String cref,
        UserResponseDTO user
) {
}
