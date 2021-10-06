package com.stock.gestionstock.validator;

import com.stock.gestionstock.dto.CommandeClientDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {
    public static List<String> validate(CommandeClientDTO commandeclientDto){
        List<String> errors=new ArrayList<>();
        if(commandeclientDto==null){
            errors.add("Veuillez renseigner sur le code de la commande");
            errors.add("Veuillez renseigner sur la date de  commande");
            errors.add("Veuillez renseigner sur l'état de la commande");
            errors.add("Veuillez renseigner sur la liste des clients");
            return  errors;
        }
        if(!StringUtils.hasLength(commandeclientDto.getCode())){
            errors.add("Veuillez renseigner sur le code de la commande");
        }
        if(commandeclientDto.getDateCommande()==null){
            errors.add("Veuillez renseigner sur la date de  commande");
        }
        if(commandeclientDto.getEtatCommande()==null){
            errors.add("Veuillez renseigner sur l'état de la commande");
        }
        if(commandeclientDto.getClient()==null){
            errors.add("Veuillez renseigner sur la liste des clients");
        }
        return errors;
    }
}
