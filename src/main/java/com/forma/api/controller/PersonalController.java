package com.forma.api.controller;

import com.forma.api.infrastructure.dto.personalDto.request.PersonalRequestUpdateDTO;
import com.forma.api.infrastructure.dto.personalDto.request.PersonalResquestPatchDTO;
import com.forma.api.infrastructure.dto.personalDto.request.PersonalRequestCreateDTO;
import com.forma.api.infrastructure.dto.personalDto.response.PersonalDetailsResponseDTO;
import com.forma.api.infrastructure.dto.personalDto.response.PersonalSummaryResponseDTO;
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
    public ResponseEntity<PersonalDetailsResponseDTO> create(@Valid @RequestBody PersonalRequestCreateDTO personal){
        PersonalDetailsResponseDTO personalCreated = personalService.create(personal);
        return ResponseEntity.status(HttpStatus.CREATED).body(personalCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalDetailsResponseDTO> getPersonal(@PathVariable UUID id){
        PersonalDetailsResponseDTO response = personalService.find(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<PersonalSummaryResponseDTO> getPersonalWithStudents(@PathVariable UUID id){
        PersonalSummaryResponseDTO response = personalService.findWithStudents(id);
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

            if (cref != null) {
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
    public ResponseEntity<PersonalSummaryResponseDTO> update(@Valid @RequestBody PersonalRequestUpdateDTO personalUpdate, @PathVariable UUID id){
        PersonalSummaryResponseDTO response = personalService.update(id, personalUpdate);
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("{id}")
    public ResponseEntity<PersonalSummaryResponseDTO> parseUpdate(@Valid @RequestBody PersonalResquestPatchDTO personalUpdate, @PathVariable UUID id){
        PersonalSummaryResponseDTO response = personalService.patch(id, personalUpdate);
        return ResponseEntity.ok().body(response);
    }
}
