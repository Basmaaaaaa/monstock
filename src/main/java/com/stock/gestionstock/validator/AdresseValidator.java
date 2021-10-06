package com.stock.gestionstock.validator;

import com.stock.gestionstock.dto.AdresseDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AdresseValidator {
 public static List<String> validate(AdresseDTO adresseDto){
     List<String> errors=new ArrayList<>();
     if(adresseDto==null){
         errors.add("le champ adresse2 est obligatoire");
         errors.add("le champ adresse1 est obligatoire");
         errors.add("le champ ville est obligatoire");
         errors.add("le champ pay est obligatoire");
         errors.add("le champ code postale est obligatoire");
         return errors;
     }
     if(StringUtils.hasLength(adresseDto.getAdresse2())){
         errors.add("le champ adresse2 est obligatoire");
     }
     if(StringUtils.hasLength(adresseDto.getAdresse1())){
         errors.add("le champ adresse1 est obligatoire");
     }
     if(StringUtils.hasLength(adresseDto.getVille())){
         errors.add("le champ ville est obligatoire");
     }
     if(StringUtils.hasLength(adresseDto.getPays())){
         errors.add("le champ pay est obligatoire");
     }
     if(StringUtils.hasLength(adresseDto.getCodePostale())){
         errors.add("le champ code postale est obligatoire");
     }
     return errors;

 }





}
