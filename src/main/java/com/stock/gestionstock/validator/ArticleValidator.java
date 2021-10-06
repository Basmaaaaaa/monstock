package com.stock.gestionstock.validator;

import com.stock.gestionstock.dto.ArticleDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {
    public static List<String> Validate(ArticleDTO articleDto){
        List<String > errors=new ArrayList<>();
        if(articleDto==null){
            errors.add("Veuillez renseigner sur le code de l'article ");
            errors.add("Veuillez renseigner  la designation de l'article ");
            errors.add("Veuillez renseigner  sur le pric unitaire hors taxe de l'article ");
            errors.add("Veuillez renseigner  sur le prix Unitaire TTC de l'article ");
            errors.add("Veuillez renseigner  la categorie de l'article ");
            return errors;
        }
        if(!StringUtils.hasLength(articleDto.getCodeArticle())){
            errors.add("Veuillez renseigner sur le code de l'article ");
        }
        if(!StringUtils.hasLength(articleDto.getDesignation())){
            errors.add("Veuillez renseigner  la designation de l'article ");
        }
        if(articleDto.getPrixUnitaireht()==null){
            errors.add("Veuillez renseigner  sur le pric unitaire hors taxe de l'article ");
        }

        if(articleDto.getPrixUnitairettc()==null){
            errors.add("Veuillez renseigner  sur le prix Unitaire TTC de l'article ");
        }
        if(articleDto.getCategory()==null){
            errors.add("Veuillez renseigner  la categorie de l'article ");
        }
        return errors;
    }
}
