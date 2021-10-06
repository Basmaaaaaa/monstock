package com.stock.gestionstock.dto;
import com.stock.gestionstock.model.LigneCommandeFournisseur;
import lombok.Builder;
import lombok.Data;
@Data
@Builder

public class LigneCommandeFournisseurDTO {
	private Integer id;
	private ArticleDTO article;
	private CommandeFournisseurDTO commandeFournisseurs;
	private Integer idEntreprise;
public static LigneCommandeFournisseurDTO fromEntity(LigneCommandeFournisseur lignecommandefournisseur){
	if(lignecommandefournisseur==null){
		return null;
	}
	return LigneCommandeFournisseurDTO.builder().id(lignecommandefournisseur.getId())
												.article(ArticleDTO.fromEntity(lignecommandefournisseur.getArticle()))
												.commandeFournisseurs(CommandeFournisseurDTO.fromEntity(lignecommandefournisseur.getCommandeFournisseurs()))
												.idEntreprise(lignecommandefournisseur.getIdEntreprise())
												.build();
}
public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDTO lignecommandefournisseurDto){
	LigneCommandeFournisseur ligneCommandeFournisseur=new LigneCommandeFournisseur();
	ligneCommandeFournisseur.setId(lignecommandefournisseurDto.getId());
	ligneCommandeFournisseur.setArticle(ArticleDTO.toEntity(lignecommandefournisseurDto.getArticle()));
	ligneCommandeFournisseur.setIdEntreprise(lignecommandefournisseurDto.getIdEntreprise());
	return ligneCommandeFournisseur;
}
}
