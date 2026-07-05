package com.forma.api.controller;

import com.forma.api.infrastructure.requestDto.PersonalPatchDTO;
import com.forma.api.infrastructure.requestDto.PersonalRequestDTO;
import com.forma.api.infrastructure.responseDto.PersonalResponseDTO;
import com.forma.api.service.PersonalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/personals")
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @PostMapping
    public ResponseEntity<PersonalResponseDTO> create(@Valid @RequestBody PersonalRequestDTO personal){
        PersonalResponseDTO personalCreated = personalService.create(personal);
        return ResponseEntity.status(HttpStatus.CREATED).body(personalCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalResponseDTO> getPersonal(@PathVariable UUID id){
        PersonalResponseDTO response = personalService.find(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @GetMapping
    public ResponseEntity<?> getPersonalByParam(
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String cref
    ){

            if (email != null) {
                return ResponseEntity.ok(personalService.findByEmail(email));
            }

            if (username != null) {
                return ResponseEntity.ok(personalService.findByUserName(username));
            }

            if (username != null) {
                return ResponseEntity.ok(personalService.findByCref(cref));
            }

        return ResponseEntity.ok(personalService.findAll());
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        personalService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<PersonalResponseDTO> update(@Valid @RequestBody PersonalRequestDTO personalUpdate, @PathVariable UUID id){
        PersonalResponseDTO response = personalService.update(id, personalUpdate);
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("{id}")
    public ResponseEntity<PersonalResponseDTO> parseUpdate(@Valid @RequestBody PersonalPatchDTO personalUpdate, @PathVariable UUID id){
        PersonalResponseDTO response = personalService.patch(id, personalUpdate);
        return ResponseEntity.ok().body(response);
    }
}
