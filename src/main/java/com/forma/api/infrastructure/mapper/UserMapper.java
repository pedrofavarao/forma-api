package com.forma.api.infrastructure.mapper;

import com.forma.api.domain.model.User;
import com.forma.api.infrastructure.requestDto.userDto.UserRequestDTO;
import com.forma.api.infrastructure.requestDto.userDto.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "userType", ignore = true)
    User toEntity(UserRequestDTO dto);
    UserResponseDTO toResponse(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "userType", ignore = true)
    void updateUserFromDto(UserRequestDTO dto, @MappingTarget User entity);
}
