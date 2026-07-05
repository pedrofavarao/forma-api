package com.forma.api.service;

import com.forma.api.domain.Role;
import com.forma.api.domain.model.Personal;
import com.forma.api.domain.repository.PersonalRepository;
import com.forma.api.infrastructure.mapper.PersonalMapper;
import com.forma.api.infrastructure.requestDto.PersonalPatchDTO;
import com.forma.api.infrastructure.requestDto.PersonalRequestDTO;
import com.forma.api.infrastructure.responseDto.PersonalResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class PersonalService {

    @Autowired
    private PersonalRepository personalRepository;

    @Autowired
    private PersonalMapper mapper;

    @Transactional
    public PersonalResponseDTO create(PersonalRequestDTO personalDto) {
        Personal personal = mapper.toEntity(personalDto);
        personal.getUser().setUserType(Role.PERSONAL);
        Personal personalCreated = personalRepository.save(personal);
        return mapper.toResponse(personalCreated);
    }

    public PersonalResponseDTO find(UUID id) {
        Optional<Personal> personalFound = personalRepository.findById(id);
        return mapper.toResponse(personalFound.orElse(null));
    }

    public PersonalResponseDTO findByEmail(String email) {
        Optional<Personal> personalFound = personalRepository.findByUserEmail(email);
        return mapper.toResponse(personalFound.orElse(null));
    }

    public PersonalResponseDTO findByUserName(String username) {
        Optional<Personal> personalFound = personalRepository.findByUserUsername(username);
        return mapper.toResponse(personalFound.orElse(null));
    }

    public PersonalResponseDTO findByCref(String cref) {
        Optional<Personal> personalFound = personalRepository.findByCref(cref);
        return mapper.toResponse(personalFound.orElse(null));
    }

    public List<PersonalResponseDTO> findAll() {
        List<Personal> personals = personalRepository.findAll();
        List<PersonalResponseDTO> listResponse = personals.stream().map(p -> mapper.toResponse(p)).toList();
        return listResponse;
    }

    @Transactional
    public void delete(UUID id) {
        personalRepository.deleteById(id);
    }

    @Transactional
    public PersonalResponseDTO update(UUID id, PersonalRequestDTO personalDto) {
        // TODO Tratar corretamente Retornos e excessões
        Personal personal = personalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personal não encontrado"));
        mapper.updateEntityFromDto(personalDto, personal);
        return mapper.toResponse(personal);
    }

    @Transactional
    public PersonalResponseDTO patch(UUID id, PersonalPatchDTO dto) {
        Personal personal = personalRepository.findById(id)
                .orElseThrow();
        mapper.patch(dto, personal);
        return mapper.toResponse(personal);
    }

}
