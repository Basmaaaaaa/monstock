package com.stock.gestionstock.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChangerMotDePasseDTO {
    private Integer id;

    private String motDePasse;

    private String confirmMotDePasse;
}
