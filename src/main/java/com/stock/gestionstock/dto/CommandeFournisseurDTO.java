package com.stock.gestionstock.dto;

import com.stock.gestionstock.model.CommandeFournisseur;
import com.stock.gestionstock.model.EtatCommande;
import lombok.Builder;
import lombok.Data;
import java.time.Instant;

@Data
@Builder
public class CommandeFournisseurDTO {
	private Integer id;
	private String code;
	private Instant dateCommande;
	private FournisseurDTO fournisseur;
	private Integer idEntreprise;
	private EtatCommande etatCommande;
	public static CommandeFournisseurDTO fromEntity(CommandeFournisseur commandefournisseur){
		if(commandefournisseur==null){
			return null;
		}return CommandeFournisseurDTO.builder().id(commandefournisseur.getId())
												.code(commandefournisseur.getCode())
												.dateCommande(commandefournisseur.getDateCommande())
												.fournisseur(FournisseurDTO.fromEntity(commandefournisseur.getFournisseur()))
												.idEntreprise(commandefournisseur.getIdEntreprise())
												.etatCommande(commandefournisseur.getEtatCommande())
												.build();
	}
	public static CommandeFournisseur toEntity(CommandeFournisseurDTO commandefournisseurDto){
		CommandeFournisseur commandefournisseur=new CommandeFournisseur();
		commandefournisseur.setId(commandefournisseurDto.getId());
		commandefournisseur.setCode(commandefournisseurDto.getCode());
		commandefournisseur.setDateCommande(commandefournisseur.getDateCommande());
		commandefournisseur.setFournisseur(FournisseurDTO.toEntity(commandefournisseurDto.getFournisseur()));
		commandefournisseur.setIdEntreprise(commandefournisseurDto.getIdEntreprise());
		commandefournisseur.setEtatCommande(commandefournisseurDto.getEtatCommande());
		return commandefournisseur;
	}


	
}
