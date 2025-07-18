package org.example.service.auth;

import java.util.Optional;

import org.example.model.Person;
import org.example.repository.PersonRepository;
import org.example.utils.auth.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
  @Autowired
  private PersonRepository personRepository;

  public boolean authenticate(String email, String password) {
    Optional<Person> optionalPerson = personRepository.findByEmail(email);

    if (optionalPerson.isEmpty())
      return false;

    Person person = optionalPerson.get();

    return PasswordUtils.checkPassword(password, person.getPassword());
  }
}
