package org.example.controller;

import org.example.dto.auth.AuthenticationRequestDTO;
import org.example.dto.auth.AuthenticationResponseDTO;
import org.example.usecase.auth.AuthenticationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/auth")
@SpringBootApplication
public class AuthenticationController {

  @Autowired
  private AuthenticationUseCase authUseCase;

  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponseDTO> login(@RequestBody AuthenticationRequestDTO request) {
    String token = authUseCase.login(request.getEmail(), request.getPassword());

    return ResponseEntity.ok(new AuthenticationResponseDTO(token));
  }
}
