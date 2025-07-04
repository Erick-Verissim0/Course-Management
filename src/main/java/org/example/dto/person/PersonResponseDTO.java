package org.example.dto.person;

import org.example.dto.company.CompanyResponseDTO;
import org.example.utils.Enum.ProfileEnum;

import java.util.UUID;

public class PersonResponseDTO {
    private UUID id;

    private String name;

    private String email;

    private ProfileEnum profile;

    private Boolean active;

    private CompanyResponseDTO company;

    public UUID getId() {
        return id;
    }

    public void setId (UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ProfileEnum getProfile() {
        return profile;
    }

    public void setProfile(ProfileEnum profile) {
        this.profile = profile;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public CompanyResponseDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyResponseDTO company) {
        this.company = company;
    }
}
