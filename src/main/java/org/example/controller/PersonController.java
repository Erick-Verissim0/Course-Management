package org.example.controller;

import org.example.dto.person.PersonRequestDTO;
import org.example.dto.person.PersonResponseDTO;
import org.example.usecase.person.PersonUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/admin/persons")
@SpringBootApplication
public class PersonController {
    private final PersonUseCase personUseCase;

    public PersonController(PersonUseCase personUseCase) {
        this.personUseCase = personUseCase;
    }

    @GetMapping
    public List<PersonResponseDTO> getAllPersons(@RequestParam Optional<Boolean> active) {
        return personUseCase.getPersons(active);
    }

    @GetMapping("/{id}")
    public PersonResponseDTO getOnePerson(@PathVariable UUID id) {
        return personUseCase.getPerson(id);
    }

    @PostMapping()
    public ResponseEntity<PersonResponseDTO> postPerson(@RequestBody PersonRequestDTO dto) {
      PersonResponseDTO created = personUseCase.postPerson(dto);

      return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable UUID id) {
      personUseCase.deletePerson(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonResponseDTO> updatePerson(@PathVariable UUID id, @RequestBody PersonRequestDTO newPerson) {
      PersonResponseDTO updatePerson = personUseCase.updatePerson(id, newPerson);

      return ResponseEntity.ok(updatePerson);
    }
}
