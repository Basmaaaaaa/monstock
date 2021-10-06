package com.stock.gestionstock.validator;
import com.stock.gestionstock.dto.EntrepriseDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {
public static List<String> Validate(EntrepriseDTO entrepriseDto){
    List<String> errors=new ArrayList<>();
    if(entrepriseDto==null){
        errors.add("Veuillez renseigner sur le nom de l'entreprise");
        errors.add("Veuillez renseigner sur le code fiscale de l'entreprise");
        errors.add("Veuillez renseigner sur l'email de l'entreprise");
        errors.add("Veuillez renseigner sur la description de l'entreprise");
        errors.add("Veuillez renseigner sur le numéro de télephone de l'entreprise");

        return errors;
    }
    if(!StringUtils.hasLength(entrepriseDto.getNom())){
        errors.add("Veuillez renseigner sur le nom de l'entreprise");
    }

    if(!StringUtils.hasLength(entrepriseDto.getCodeFiscal())){
        errors.add("Veuillez renseigner sur le code fiscale de l'entreprise");
    }
    if(!StringUtils.hasLength(entrepriseDto.getEmail())){
        errors.add("Veuillez renseigner sur l'email de l'entreprise");
    }
    if(!StringUtils.hasLength(entrepriseDto.getDescription())){
        errors.add("Veuillez renseigner sur la description de l'entreprise");
    }
    if(!StringUtils.hasLength(entrepriseDto.getNumTel())){
        errors.add("Veuillez renseigner sur le numéro de télephone de l'entreprise");
    }
    errors.addAll(AdresseValidator.validate(null));
    return errors;
}
}
