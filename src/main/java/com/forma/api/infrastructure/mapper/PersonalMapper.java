package com.forma.api.infrastructure.mapper;

import com.forma.api.domain.model.Personal;
import com.forma.api.infrastructure.requestDto.PersonalPatchDTO;
import com.forma.api.infrastructure.requestDto.PersonalRequestDTO;
import com.forma.api.infrastructure.responseDto.PersonalResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = UserMapper.class
)
public interface PersonalMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "students", ignore = true)
    Personal toEntity(PersonalRequestDTO dto);

    PersonalResponseDTO toResponse(Personal personal);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "user", ignore = true)
    void updateEntityFromDto(PersonalRequestDTO dto, @MappingTarget Personal entity);

    void patch(PersonalPatchDTO dto, @MappingTarget Personal personal);
}