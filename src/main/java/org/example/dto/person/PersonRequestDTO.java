package org.example.dto.person;

import org.example.utils.Enum.ProfileEnum;

import java.util.UUID;

public class PersonRequestDTO {
    private UUID id;

    private String name;

    private String email;

    private String password;

    private ProfileEnum profile;

    private Boolean active;

    private UUID company;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public UUID getCompanyId() {
        return company;
    }

    public void setCompanyId(UUID id) {
        this.company = id;
    }
}
