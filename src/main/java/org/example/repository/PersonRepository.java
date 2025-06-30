package org.example.repository;

import org.example.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PersonRepository extends  JpaRepository<Person, UUID> {
}
