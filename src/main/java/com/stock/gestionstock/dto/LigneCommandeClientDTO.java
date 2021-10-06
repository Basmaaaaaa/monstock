package com.stock.gestionstock.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stock.gestionstock.model.LigneCommandeClient;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeClientDTO {

	private Integer id;
	private ArticleDTO article;
	@JsonIgnore
	private CommandeClientDTO commandeClient;
	private BigDecimal quantite;
	private BigDecimal prixUnitaire;
	private Integer idEntreprise;


public  static LigneCommandeClientDTO fromEntity(LigneCommandeClient lignecommandeclient){
	if(lignecommandeclient==null){
		return null;
	}return LigneCommandeClientDTO.builder().id(lignecommandeclient.getId())
											.article(ArticleDTO.fromEntity(lignecommandeclient.getArticle()))
											.commandeClient(CommandeClientDTO.fromEntity(lignecommandeclient.getCommandeClient()))
											.quantite(lignecommandeclient.getQuantite())
											.prixUnitaire(lignecommandeclient.getPrixUnitaire())
											.idEntreprise(lignecommandeclient.getIdEntreprise())
											.build();
}
public  static LigneCommandeClient toEntity(LigneCommandeClientDTO lignecommandeclientDto){
	LigneCommandeClient ligneCommandeClient =new LigneCommandeClient();
	ligneCommandeClient.setId(lignecommandeclientDto.getId());
	ligneCommandeClient.setArticle(ArticleDTO.toEntity(lignecommandeclientDto.getArticle()));
	ligneCommandeClient.setCommandeClient(CommandeClientDTO.toEntity(lignecommandeclientDto.getCommandeClient()));
	ligneCommandeClient.setQuantite(lignecommandeclientDto.getQuantite());
	ligneCommandeClient.setPrixUnitaire(lignecommandeclientDto.getPrixUnitaire());
	ligneCommandeClient.setIdEntreprise(lignecommandeclientDto.getIdEntreprise());
	return ligneCommandeClient;
}
}
