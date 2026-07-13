package com.forma.api.infrastructure.mapper;

import com.forma.api.domain.model.Student;
import com.forma.api.infrastructure.dto.studentDto.request.StudentRequestCreateDTO;
import com.forma.api.infrastructure.dto.studentDto.request.StudentRequestUpdateDTO;
import com.forma.api.infrastructure.dto.studentDto.response.StudentResponseDTO;
import com.forma.api.infrastructure.dto.studentDto.request.StudentResquestPatchDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = UserMapper.class
)
public interface StudentMapper {

    @Mapping(target = "id", ignore = true)
    Student toEntity(StudentRequestCreateDTO dto);
    // TODO mapper to entity

    StudentResponseDTO toResponse(Student personal);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    void update(StudentRequestUpdateDTO dto, @MappingTarget Student entity);
    // TODO mapper to update

    @Mapping(target = "user", ignore = true)
    void patch(StudentResquestPatchDTO dto, @MappingTarget Student entity);
    // TODO mapper to patch
}
