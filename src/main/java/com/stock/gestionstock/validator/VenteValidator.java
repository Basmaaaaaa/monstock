package com.stock.gestionstock.validator;

import com.stock.gestionstock.dto.VenteDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VenteValidator {
    public static List<String> validate(VenteDTO venteDto){
        List<String> errors=new ArrayList<>();
        if(venteDto==null){
            errors.add("Veuillez renseigner sur le code de la commande");
            errors.add("Veuillez renseigner sur la date de vente ");
            return  errors;
        }
        if(!StringUtils.hasLength(venteDto.getCode())){
            errors.add("Veuillez renseigner sur le code de la commande");
        }
        if(venteDto.getDateVente()==null){
            errors.add("Veuillez renseigner sur la date de vente ");
        }
        return errors;
    }
}
