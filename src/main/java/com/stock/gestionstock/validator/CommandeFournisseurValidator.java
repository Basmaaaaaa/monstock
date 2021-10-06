package com.stock.gestionstock.validator;

import com.stock.gestionstock.dto.CommandeFournisseurDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeFournisseurValidator {
    //je veaux valider le code/date/etat/client
    public static List<String>validate(CommandeFournisseurDTO commandefournisseurDto){
        List<String> errors=new ArrayList<>();
        if(commandefournisseurDto==null){
            errors.add("Veuillez renseigner sur le code de la commande fournisseur ");
            errors.add("Veuillez renseigner sur la date de la commande fournisseur ");
            errors.add("Veuillez renseigner sur l'état de la commande fournisseur ");
            errors.add("Veuillez renseigner le fournisseur");
            return errors;
        }
        if(!StringUtils.hasLength(commandefournisseurDto.getCode())){
            errors.add("Veuillez renseigner sur le code de la commande fournisseur ");
        }
        if(commandefournisseurDto.getDateCommande()==null){
            errors.add("Veuillez renseigner sur la date de la commande fournisseur ");
        }
        if(commandefournisseurDto.getEtatCommande()==null){
            errors.add("Veuillez renseigner sur l'état de la commande fournisseur ");
        }
        if (commandefournisseurDto.getFournisseur() == null || commandefournisseurDto.getFournisseur().getId() == null) {
            errors.add("Veuillez renseigner le fournisseur");
        }
        return errors;
    }

}
