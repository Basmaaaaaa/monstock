package com.stock.gestionstock.validator;

import com.stock.gestionstock.dto.LigneCommandeClientDTO;
import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {
    public static List<String> validate(LigneCommandeClientDTO ligneCommandeClientDto){
        List<String>errors=new ArrayList<>();

        if(ligneCommandeClientDto==null){
            errors.add("Veuillez renseigner sur l'article de de la commande");
            errors.add("Veuillez renseigner sur la quantité de de la commande");
            errors.add("Veuillez renseigner sur la  commande client");
            errors.add("Veuillez renseigner sur le prix unitaire de la commande");
            return errors;
        }
        if(ligneCommandeClientDto.getArticle()==null){
            errors.add("Veuillez renseigner sur l'article de de la commande");
        }
        if(ligneCommandeClientDto.getQuantite()==null){
            errors.add("Veuillez renseigner sur la quantité de de la commande");
        }
        if(ligneCommandeClientDto.getCommandeClient()==null){
            errors.add("Veuillez renseigner sur la  commande client");
        }
        if(ligneCommandeClientDto.getPrixUnitaire()==null){
            errors.add("Veuillez renseigner sur le prix unitaire de la commande");
        }
        return errors;
    }
}
