package com.forma.api.infrastructure.dto.personalDto.response;

import com.forma.api.infrastructure.dto.studentDto.response.StudentResponseDTO;
import com.forma.api.infrastructure.dto.userDto.response.UserResponseDTO;

import java.util.List;
import java.util.UUID;

public record PersonalSummaryResponseDTO(
        UUID id,
        String name,
        String cref,
        UserResponseDTO user
) {
}
