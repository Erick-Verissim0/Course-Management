package org.example.usecase.person;

import org.example.dto.person.PersonRequestDTO;
import org.example.dto.person.PersonResponseDTO;
import org.example.helper.PersonMapper;
import org.example.model.Company;
import org.example.model.Person;
import org.example.repository.CompanyRepository;
import org.example.repository.PersonRepository;
import org.example.utils.auth.PasswordUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonUseCaseImpl implements PersonUseCase {
    private final PersonRepository personRepository;
    private final CompanyRepository companyRepository;

    public PersonUseCaseImpl(PersonRepository personRepository, CompanyRepository companyRepository) {
        this.personRepository = personRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<PersonResponseDTO> getPersons(Optional<Boolean> active) {
        List<Person> persons = personRepository.findAll();
        return persons.stream().map(PersonMapper::toDTO).filter(
                user -> active.isEmpty() || user.getActive().equals(
                        active.get())).toList();
    }

    @Override
    public PersonResponseDTO getPerson(UUID id) {
        Person person = personRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Person not found"));

        return PersonMapper.toDTO(person);
    }

    @Override
    public PersonResponseDTO postPerson(PersonRequestDTO dto) {
        Person person = new Person();

        Company company = companyRepository.findById(
                dto.getCompanyId()).orElseThrow(
                () -> new RuntimeException("Company not found!"));

        String hashPassword = PasswordUtils.hashPassword(dto.getPassword());

        person.setName(dto.getName());
        person.setEmail(dto.getEmail());
        person.setPassword(hashPassword);
        person.setProfile(dto.getProfile());
        person.setActive(dto.getActive());
        person.setCompany(company);

        personRepository.save(person);

        return PersonMapper.toDTO(person);
    }

    @Override
    public void deletePerson(UUID id) {
      Person person = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found!"));

      person.setActive(false);
      personRepository.save(person);
    }

    // FALTA O PUT
}
