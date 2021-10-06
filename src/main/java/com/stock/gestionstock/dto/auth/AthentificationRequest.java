package com.stock.gestionstock.dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AthentificationRequest {
    private String login;
    private String password;

}
