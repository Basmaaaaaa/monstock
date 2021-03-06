package com.stock.gestionstock.validator;

import com.stock.gestionstock.dto.ClientDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {
    public static List<String> validate(ClientDTO clientDto) {
        List<String> errors = new ArrayList<>();
        if (clientDto == null) {
            errors.add("Veuillez renseigner sur le nom de client");
            errors.add("Veuillez renseigner sur le prenom de client");
            errors.add("Veuillez renseigner sur l'email de client");
            errors.add("Veuillez renseigner sur le numéro de télephone de client");
            return errors;

        }
        if (!StringUtils.hasLength(clientDto.getNom())) {
            errors.add("Veuillez renseigner sur le nom de client");
        }
        if (!StringUtils.hasLength(clientDto.getPrenom())) {
            errors.add("Veuillez renseigner sur le prenom de client");
        }
        if (!StringUtils.hasLength(clientDto.getMail())) {
            errors.add("Veuillez renseigner sur l'email de client");
        }

        if (!StringUtils.hasLength(clientDto.getNumTel())) {
            errors.add("Veuillez renseigner sur le numéro de télephone de client");
        }
        return errors;
    }
}
