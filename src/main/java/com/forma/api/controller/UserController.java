package com.forma.api.controller;

import com.forma.api.infrastructure.dto.userDto.request.UserRequestCreateDTO;
import com.forma.api.infrastructure.dto.userDto.request.UserRequestPatchDTO;
import com.forma.api.infrastructure.dto.userDto.request.UserRequestUpdateDTO;
import com.forma.api.infrastructure.dto.userDto.response.UserResponseDTO;
import com.forma.api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@Valid @RequestBody UserRequestCreateDTO user){
        UserResponseDTO userCreated = userService.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getPersonal(@PathVariable UUID id){
        UserResponseDTO response = userService.find(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @GetMapping
    public ResponseEntity<?> getPersonalByParam(
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String cref
    ){

        if (email != null) {
            return ResponseEntity.ok(userService.findByEmail(email));
        }

        if (username != null) {
            return ResponseEntity.ok(userService.findByUserName(username));
        }

        return ResponseEntity.ok(userService.findAll());
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<UserResponseDTO> update(@Valid @RequestBody UserRequestUpdateDTO userUpdate, @PathVariable UUID id){
        UserResponseDTO response = userService.update(id, userUpdate);
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("{id}")
    public ResponseEntity<UserResponseDTO> parseUpdate(@Valid @RequestBody UserRequestPatchDTO userUpdate, @PathVariable UUID id){
        UserResponseDTO response = userService.patch(id, userUpdate);
        return ResponseEntity.ok().body(response);
    }
}
