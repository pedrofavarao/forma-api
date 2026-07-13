package com.forma.api.infrastructure.mapper;

import com.forma.api.domain.model.User;
import com.forma.api.infrastructure.dto.userDto.request.UserRequestCreateDTO;
import com.forma.api.infrastructure.dto.userDto.request.UserRequestDTO;
import com.forma.api.infrastructure.dto.userDto.request.UserRequestPatchDTO;
import com.forma.api.infrastructure.dto.userDto.request.UserRequestUpdateDTO;
import com.forma.api.infrastructure.dto.userDto.response.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "userType", ignore = true)
    User toEntity(UserRequestDTO dto);
    UserResponseDTO toResponse(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateUserFromDto(UserRequestUpdateDTO dto, @MappingTarget User entity);

    @Mapping(target = "id", ignore = true)
    User toEntity(UserRequestCreateDTO dto);

    void patch(UserRequestPatchDTO dto, @MappingTarget User entity);
}
