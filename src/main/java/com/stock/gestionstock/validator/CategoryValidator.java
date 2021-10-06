package com.stock.gestionstock.validator;

import com.stock.gestionstock.dto.CategoryDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public  static List<String> validate(CategoryDTO categoryDto){
        List<String> errors=new ArrayList<>() ;

        if(!StringUtils.hasLength(categoryDto.getCode())){
          errors.add("veuillez renseigner le code de categorie");

        }
      return errors;
    }
}
