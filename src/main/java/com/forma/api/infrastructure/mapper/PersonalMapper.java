package com.forma.api.infrastructure.mapper;

import com.forma.api.domain.model.Personal;
import com.forma.api.infrastructure.requestDto.personalDto.PersonalRequestUpdateDTO;
import com.forma.api.infrastructure.requestDto.personalDto.PersonalResquestPatchDTO;
import com.forma.api.infrastructure.requestDto.personalDto.PersonalRequestCreateDTO;
import com.forma.api.infrastructure.requestDto.personalDto.PersonalResponseDTO;
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
    Personal toEntity(PersonalRequestCreateDTO dto);

    PersonalResponseDTO toResponse(Personal personal);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "user", ignore = true)
    void update(PersonalRequestUpdateDTO dto, @MappingTarget Personal entity);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "students", ignore = true)
    void patch(PersonalResquestPatchDTO dto, @MappingTarget Personal personal);
}