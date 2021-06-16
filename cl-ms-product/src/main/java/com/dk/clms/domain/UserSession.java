package com.dk.clms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSession {
    public String accessToken;
    public String refreshToken;
}
