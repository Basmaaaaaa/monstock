package com.stock.gestionstock.dto;

import com.stock.gestionstock.model.Article;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Builder
@Data
public class ArticleDTO {
	private Integer id;
	private String codeArticle; 
	private String designation;
	private BigDecimal prixUnitaireht;
	private BigDecimal prixUnitairettc;
	private BigDecimal tauxTva;
	private String photo;
	private CategoryDTO category;
	private Integer idEntreprise;

	//le mapping de ArticleDTO ---->Entité
public static  ArticleDTO fromEntity(Article article){
	if(article==null){
		return null;
	}return ArticleDTO.builder().id(article.getId())
			                    .codeArticle(article.getCodeArticle())
								.designation(article.getDesignation())
								.prixUnitaireht(article.getPrixUnitaireHt())
								.prixUnitairettc(article.getPrixUnitaireTtc())
								.tauxTva(article.getTauxTva())
								.photo(article.getPhoto())
								.idEntreprise(article.getIdEntreprise())
								.category(CategoryDTO.fromEntity(article.getCategory()))
								.build();
}
public static Article toEntity(ArticleDTO articleDto){
	if(articleDto==null){
	return null;
	}
	Article article=new Article();
	article.setId(articleDto.getId());
	article.setCodeArticle(articleDto.getCodeArticle());
	article.setDesignation(articleDto.getDesignation());
	article.setPrixUnitaireHt(articleDto.getPrixUnitaireht());
	article.setPrixUnitaireTtc(articleDto.getPrixUnitairettc());
	article.setTauxTva(articleDto.getTauxTva());
	article.setPhoto(articleDto.getPhoto());
	article.setIdEntreprise(articleDto.getIdEntreprise());
	article.setCategory(CategoryDTO.toEntity(articleDto.getCategory()));
	return article;
}
}
