package com.stock.gestionstock.validator;

import com.stock.gestionstock.dto.FournisseurDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidate {
    public  static List<String> Validate(FournisseurDTO fournisseurDto){
        List<String> errors=new ArrayList<>();
        if (fournisseurDto== null) {
            errors.add("Veuillez renseigner sur le nom de fournisseur");
            errors.add("Veuillez renseigner sur le prenom de fournisseur");
            errors.add("Veuillez renseigner sur l'email de fournisseur");
            errors.add("Veuillez renseigner sur le numéro de télephone de fournisseur");
            return errors;

        }
        if (!StringUtils.hasLength(fournisseurDto.getNom())) {
            errors.add("Veuillez renseigner sur le nom de fournisseur");
        }
        if (!StringUtils.hasLength(fournisseurDto.getPrenom())) {
            errors.add("Veuillez renseigner sur le prenom de fournisseur");
        }
        if (!StringUtils.hasLength(fournisseurDto.getMail())) {
            errors.add("Veuillez renseigner sur l'email de fournisseur");
        }

        if (!StringUtils.hasLength(fournisseurDto.getNumTel())) {
            errors.add("Veuillez renseigner sur le numéro de télephone de fournisseur");
        }
        return errors;
    }

    }

