package com.stock.gestionstock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stock.gestionstock.model.Entreprise;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EntrepriseDTO {
	private Integer idEntreprise;
	private String nom;
	private AdresseDTO adresse;
	private String codeFiscal;
	private String photo;
	private String email;
	private String description;
	private String numTel;
	private String siteWeb;
	@JsonIgnore
	private List<UtilisateurDTO> utilisateurs;
public static EntrepriseDTO fromEntity(Entreprise entreprise)
{
	if(entreprise==null){
		return null;
	}return EntrepriseDTO.builder().idEntreprise(entreprise.getIdEntreprise())
									.nom(entreprise.getNom())
									.adresse(AdresseDTO.fromEntity(entreprise.getAdresse()))
									.codeFiscal(entreprise.getCodeFiscal())
									.photo(entreprise.getPhoto())
									.email(entreprise.getEmail())
									.description(entreprise.getDescription())
									.numTel(entreprise.getNumTel())
									.siteWeb(entreprise.getSiteWeb())
									.build();
}
public static Entreprise toEntity(EntrepriseDTO entrepriseDto){
	Entreprise entreprise=new Entreprise();
	entreprise.setIdEntreprise(entrepriseDto.getIdEntreprise());
	entreprise.setNom(entrepriseDto.getNom());
	entreprise.setAdresse(AdresseDTO.toEntity(entrepriseDto.getAdresse()));
	entreprise.setCodeFiscal(entrepriseDto.getCodeFiscal());
	entreprise.setPhoto(entrepriseDto.getPhoto());
	entreprise.setEmail(entrepriseDto.getEmail());
	entreprise.setDescription(entrepriseDto.getDescription());
	entreprise.setNumTel(entrepriseDto.getNumTel());
	entreprise.setSiteWeb(entrepriseDto.getSiteWeb());
	return entreprise;
}
}
