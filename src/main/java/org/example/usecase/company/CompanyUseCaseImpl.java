package org.example.usecase.company;

import org.example.model.Company;
import org.example.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyUseCaseImpl implements CompanyUseCase {
    private final CompanyRepository companyRepository;

    public CompanyUseCaseImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Optional<Company> getOneCompany(UUID id) {
        return companyRepository.findById(id);
    }
}
