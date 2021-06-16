package com.dk.clms.service;

import com.dk.clms.domain.UserSession;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KeycloakService {

    @Value("${keycloak.auth-server-url}")
    private  String serverUrl;

    @Value("${keycloak.realm}")
    private  String realm;

    @Value("${keycloak.resource}")
    private  String clientId;

    @Value("${keycloak.credentials.secret}")
    private  String clientSecret;

    public UserSession getUserSession(String username, String password) {
        Keycloak keycloak = KeycloakBuilder.builder()
                .grantType("password")
                .serverUrl(serverUrl)
                .realm(realm)
                .username(username)
                .password(password)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .build();

        AccessTokenResponse tokenResponse = keycloak.tokenManager().getAccessToken();
        String accessToken = tokenResponse.getToken();
        String refreshToken = tokenResponse.getRefreshToken();

        return new UserSession(accessToken, refreshToken);
    }
}
