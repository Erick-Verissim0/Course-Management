package org.example.service.Person;

import org.example.model.Person;
import org.example.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonUseCaseImpl implements PersonUseCase{
    private final PersonRepository personRepository;

    public PersonUseCaseImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getPersons() {
        return personRepository.findAll();
    }
}
