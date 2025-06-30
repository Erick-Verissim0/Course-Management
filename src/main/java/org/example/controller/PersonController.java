package org.example.controller;

import org.example.model.Person;
import org.example.service.Person.PersonUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@RestController
@RequestMapping("/persons")
@SpringBootApplication
public class PersonController {
    private final PersonUseCase personUseCase;

    public PersonController(PersonUseCase personUseCase) {
        this.personUseCase = personUseCase;
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personUseCase.getPersons();
    }
}
