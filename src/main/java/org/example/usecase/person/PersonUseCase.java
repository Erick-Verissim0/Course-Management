package org.example.usecase.person;

import org.example.dto.person.PersonRequestDTO;
import org.example.dto.person.PersonResponseDTO;
import org.example.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonUseCase {
    List<PersonResponseDTO> getPersons(Optional<Boolean> active);

    PersonResponseDTO getPerson(UUID id);

    PersonResponseDTO postPerson(PersonRequestDTO dto);

    void deletePerson(UUID id);
}
