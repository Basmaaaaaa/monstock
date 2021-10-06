package com.stock.gestionstock.validator;

import com.stock.gestionstock.dto.MvtStockDTO;

import java.util.ArrayList;
import java.util.List;

public class MvtStockValidator {
    public static List<String> validate(MvtStockDTO mvtstockDto) {
        List<String> errors = new ArrayList<>();
        if(mvtstockDto==null){
            errors.add("Veuillez renseigner sur la date de mouvement de stock");
            errors.add("Veuillez renseigner sur la quantité de stock");
            errors.add("Veuillez renseigner sur la quantité de stock");
            return errors;
        }
        if(mvtstockDto.getDateMvt()==null){
            errors.add("Veuillez renseigner sur la date de mouvement de stock");
        }
        if(mvtstockDto.getQuantite()==null){
            errors.add("Veuillez renseigner sur la quantité de stock");
        }
        if(mvtstockDto.getArticle()==null){
            errors.add("Veuillez renseigner sur la quantité de stock");
        }
    return errors;
    }
}