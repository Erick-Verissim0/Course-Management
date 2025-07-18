package org.example.dto.auth;

public class AuthenticationResponseDTO {
  private String token;

  public AuthenticationResponseDTO(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
