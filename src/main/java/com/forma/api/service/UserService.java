package com.forma.api.service;

import com.forma.api.domain.model.User;
import com.forma.api.domain.repository.UserRepository;
import com.forma.api.infrastructure.dto.userDto.request.UserRequestPatchDTO;
import com.forma.api.infrastructure.mapper.UserMapper;
import com.forma.api.infrastructure.dto.userDto.request.UserRequestCreateDTO;
import com.forma.api.infrastructure.dto.userDto.request.UserRequestUpdateDTO;
import com.forma.api.infrastructure.dto.userDto.response.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper mapper;

    @Transactional
    public UserResponseDTO create(UserRequestCreateDTO userDto) {
        User user = mapper.toEntity(userDto);
        User userCreated = userRepository.save(user);
        return mapper.toResponse(userCreated);
    }

    public UserResponseDTO find(UUID id) {
        Optional<User> userFound = userRepository.findById(id);
        return mapper.toResponse(userFound.orElse(null));
    }

    public UserResponseDTO findByEmail(String email) {
        Optional<User> userFound = userRepository.findByEmail(email);
        return mapper.toResponse(userFound.orElse(null));
    }

    public UserResponseDTO findByUserName(String username) {
        Optional<User> personalFound = userRepository.findByUsername(username);
        return mapper.toResponse(personalFound.orElse(null));
    }

    public List<UserResponseDTO> findAll() {
        List<User> personals = userRepository.findAll();
        List<UserResponseDTO> listResponse = personals.stream().map(u -> mapper.toResponse(u)).toList();
        return listResponse;
    }

    @Transactional
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public UserResponseDTO update(UUID id, UserRequestUpdateDTO userDto) {
        // TODO Tratar corretamente Retornos e excessões
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        mapper.updateUserFromDto(userDto, user);
        return mapper.toResponse(user);
    }

    @Transactional
    public UserResponseDTO patch(UUID id, UserRequestPatchDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow();
        mapper.patch(dto, user);
        return mapper.toResponse(user);
    }
}
