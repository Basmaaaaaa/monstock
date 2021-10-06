package com.stock.gestionstock.validator;

import com.stock.gestionstock.dto.UtilisateurDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {
    public  static List<String> validate(UtilisateurDTO utilisateurDTO){
        List<String> errors=new ArrayList<>() ;
        if(utilisateurDTO==null){
            errors.add("Veuillez renseigner le nom d'utilisateur");
            errors.add("Veuillez renseigner le prenom d'utilisateur");
            errors.add("Veuillez renseigner l'email d'utilisateur");
            errors.add("Veuillez renseigner le mot de passe d'utilisateur");
            errors.add("Veuillez renseigner la date de naissance  d'utilisateur");
            errors.add("Veuillez renseigner l'adresse d'utilisateur");
            return errors;
        }


        if(!StringUtils.hasLength(utilisateurDTO.getNom())){
            errors.add("Veuillez renseigner le nom d'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDTO.getPrenom())){
            errors.add("Veuillez renseigner le prenom d'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDTO.getEmail())){
            errors.add("Veuillez renseigner l'email d'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDTO.getPassword())){
            errors.add("Veuillez renseigner le mot de passe d'utilisateur");
        }
        //validation sur la date de naissance
        if(utilisateurDTO.getDateNaissance()==null){
            errors.add("Veuillez renseigner la date de naissance  d'utilisateur");
        }
        //validation sur l'adresse
        if(utilisateurDTO.getAdresse()==null){
            errors.add("Veuillez renseigner l'adresse d'utilisateur");
        }
        else{
            if(!StringUtils.hasLength(utilisateurDTO.getAdresse().getAdresse1())){
                errors.add("le champ 'adresse 1' est obligatoire");
            }
            if(!StringUtils.hasLength(utilisateurDTO.getAdresse().getCodePostale())){
                errors.add("le champ 'code postale' est obligatoire");
            }
            if(!StringUtils.hasLength(utilisateurDTO.getAdresse().getPays())){
                errors.add("le champ 'pay' est obligatoire");
            }
            if(!StringUtils.hasLength(utilisateurDTO.getAdresse().getVille())){
                errors.add("le champ 'ville' est obligatoire");
            }}

        return errors;
    }
}
