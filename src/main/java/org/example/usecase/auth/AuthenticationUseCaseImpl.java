package org.example.usecase.auth;

import org.example.model.Person;
import org.example.repository.PersonRepository;
import org.example.service.auth.JwtService;
import org.example.utils.auth.PasswordUtils;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationUseCaseImpl implements AuthenticationUseCase {
  private final PersonRepository personRepository;

  private final JwtService jwtService;

  public AuthenticationUseCaseImpl(PersonRepository personRepository, JwtService jwtService) {
    this.personRepository = personRepository;
    this.jwtService = jwtService;
  }

  @Override
  public String login(String email, String password) {
    Person person = this.personRepository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("Person not found!"));

    if (!PasswordUtils.checkPassword(password, person.getPassword())) {
      throw new RuntimeException("Invalid password!");
    }

    return jwtService.generateToken(email);
  }
}
