package com.dk.clms.controller;

import com.dk.clms.domain.UserSession;
import com.dk.clms.service.KeycloakService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class LoginController {

    private final KeycloakService keycloakService;

    public LoginController(KeycloakService keycloakService) {
        this.keycloakService = keycloakService;
    }

    @PostMapping("/userSession")
    public ResponseEntity<UserSession> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        log.info(username + " login");
        UserSession userSession = keycloakService.getUserSession(username, password);

        return new ResponseEntity<>(userSession, HttpStatus.ACCEPTED);
    }
}
