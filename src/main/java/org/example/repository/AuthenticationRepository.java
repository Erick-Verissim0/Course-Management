package org.example.repository;

import java.util.Optional;
import java.util.UUID;

import org.example.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthenticationRepository extends JpaRepository<Person, UUID> {
  Optional<Person> findByEmail(String email);
}
