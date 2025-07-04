package org.example.helper;

import org.example.dto.company.CompanyResponseDTO;
import org.example.dto.person.PersonResponseDTO;
import org.example.model.Company;
import org.example.model.Person;

public class PersonMapper {
    public static PersonResponseDTO toDTO(Person person) {
        PersonResponseDTO dto = new PersonResponseDTO();
        dto.setId(person.getId());
        dto.setName(person.getName());
        dto.setEmail(person.getEmail());
        dto.setProfile(person.getProfile());
        dto.setActive(person.isActive());

        Company company = person.getCompany();
        if (company != null) {
            CompanyResponseDTO companyDTO = new CompanyResponseDTO();
            companyDTO.setId(company.getId());
            companyDTO.setName(company.getName());
            companyDTO.setCnpj(company.getCnpj());
            companyDTO.setEmail(company.getEmail());
            companyDTO.setTelephone(company.getTelephone());
            companyDTO.setAddress(company.getAddress());
            companyDTO.setCreatedAt(company.getCreatedAt());

            dto.setCompany(companyDTO);
        }

        return dto;
    }


    public static Person toEntity(PersonResponseDTO dto, Company company) {
        Person person = new Person();
        person.setName(dto.getName());
        person.setEmail(dto.getEmail());
        person.setProfile(dto.getProfile());
        person.setActive(dto.getActive());
        person.setCompany(company);
        return person;
    }
}
