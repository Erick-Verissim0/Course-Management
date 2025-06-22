package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RestController
@SpringBootApplication
public class UsersController {
    @GetMapping("/users")
    public static String getUsers() {
        return "Testando rota!";
    }
}
