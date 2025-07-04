package org.example.usecase.company;

import org.example.model.Company;

import java.util.Optional;
import java.util.UUID;

public interface CompanyUseCase {
    Optional<Company> getOneCompany(UUID id);
}
