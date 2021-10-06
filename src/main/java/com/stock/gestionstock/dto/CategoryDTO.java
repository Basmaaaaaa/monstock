package com.stock.gestionstock.dto;

import com.stock.gestionstock.model.Category;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoryDTO {
	private Integer id;
	private String code;
	private String designation;
	private Integer idEntreprise;
	
//mapping de categoryDTO ->category
public static CategoryDTO fromEntity(Category category){
	if(category==null){
		return null;
	}
	return CategoryDTO.builder().id(category.getId())
								.code(category.getCode())
								.designation(category.getDesignation())
								.idEntreprise(category.getIdEntreprise())
								.build();
}
//mapping inverse de categoryDTO <--  category
public  static Category toEntity(CategoryDTO categoryDto){
	Category category=new Category();
	category.setId(categoryDto.getId());
	category.setCode(categoryDto.getCode());
	category.setDesignation(categoryDto.getDesignation());
	category.setIdEntreprise(categoryDto.getIdEntreprise());
	return category;
}


}
