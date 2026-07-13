package com.forma.api.service;

import com.forma.api.domain.Role;
import com.forma.api.domain.model.Personal;
import com.forma.api.domain.repository.PersonalRepository;
import com.forma.api.infrastructure.dto.personalDto.response.PersonalDetailsResponseDTO;
import com.forma.api.infrastructure.dto.personalDto.response.PersonalSummaryResponseDTO;
import com.forma.api.infrastructure.mapper.PersonalMapper;
import com.forma.api.infrastructure.dto.personalDto.request.PersonalRequestUpdateDTO;
import com.forma.api.infrastructure.dto.personalDto.request.PersonalResquestPatchDTO;
import com.forma.api.infrastructure.dto.personalDto.request.PersonalRequestCreateDTO;
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
    public PersonalDetailsResponseDTO create(PersonalRequestCreateDTO personalDto) {
        Personal personal = mapper.toEntity(personalDto);
        personal.getUser().setUserType(Role.PERSONAL);
        Personal personalCreated = personalRepository.save(personal);
        return mapper.toResponse(personalCreated);
    }

    public PersonalDetailsResponseDTO find(UUID id) {
        Optional<Personal> personalFound = personalRepository.findById(id);
        return mapper.toResponse(personalFound.orElse(null));
    }

    public PersonalSummaryResponseDTO findWithStudents(UUID id) {
        Optional<Personal> personalFound = personalRepository.findCompleteById(id);
        return mapper.toSimpleResponse(personalFound.orElse(null));
    }

    public PersonalSummaryResponseDTO findByEmail(String email) {
        Optional<Personal> personalFound = personalRepository.findByUserEmail(email);
        return mapper.toSimpleResponse(personalFound.orElse(null));
    }

    public PersonalSummaryResponseDTO findByUserName(String username) {
        Optional<Personal> personalFound = personalRepository.findByUserUsername(username);
        return mapper.toSimpleResponse(personalFound.orElse(null));
    }

    public PersonalSummaryResponseDTO findByCref(String cref) {
        Optional<Personal> personalFound = personalRepository.findByCref(cref);
        return mapper.toSimpleResponse(personalFound.orElse(null));
    }

    public List<PersonalSummaryResponseDTO> findAll() {
        List<Personal> personals = personalRepository.findAll();
        List<PersonalSummaryResponseDTO> listResponse = personals.stream().map(p -> mapper.toSimpleResponse(p)).toList();
        return listResponse;
    }

    @Transactional
    public void delete(UUID id) {
        personalRepository.deleteById(id);
    }

    @Transactional
    public PersonalSummaryResponseDTO update(UUID id, PersonalRequestUpdateDTO personalDto) {
        // TODO Tratar corretamente Retornos e excessões
        Personal personal = personalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personal not found"));
        mapper.update(personalDto, personal);
        return mapper.toSimpleResponse(personal);
    }

    @Transactional
    public PersonalSummaryResponseDTO patch(UUID id, PersonalResquestPatchDTO dto) {
        Personal personal = personalRepository.findById(id)
                .orElseThrow();
        mapper.patch(dto, personal);
        return mapper.toSimpleResponse(personal);
    }

}
