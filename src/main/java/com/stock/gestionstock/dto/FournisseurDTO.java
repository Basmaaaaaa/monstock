package com.stock.gestionstock.dto;

import com.stock.gestionstock.model.Adresse;
import com.stock.gestionstock.model.Fournisseur;
import lombok.Builder;
import lombok.Data;
@Data
@Builder

public class FournisseurDTO {
	private Integer id;
	private String nom;
	private String prenom;
	private String photo;
	private String mail;
	private Adresse adresse;
	private String numTel;
	private Integer idEntreprise;
	public  static FournisseurDTO fromEntity(Fournisseur fournisseur){
		if(fournisseur==null){
			return null;
		}
		return FournisseurDTO.builder().id(fournisseur.getId())
										.nom(fournisseur.getNom())
										.prenom(fournisseur.getPrenom())
										.photo(fournisseur.getPhoto())
										.mail(fournisseur.getMail())
										.adresse(fournisseur.getAdresse())
										.numTel(fournisseur.getNumTel())
										.idEntreprise(fournisseur.getIdEntreprise())
										.build();
	}
public  static Fournisseur toEntity(FournisseurDTO fournisseurDto){
		Fournisseur fournisseur=new Fournisseur();
		fournisseur.setId(fournisseurDto.getId());
		fournisseur.setNom(fournisseurDto.getNom());
		fournisseur.setPrenom(fournisseurDto.getPrenom());
		fournisseur.setPhoto(fournisseurDto.getPhoto());
		fournisseur.setMail(fournisseurDto.getMail());
		fournisseur.setAdresse(fournisseurDto.getAdresse());
		fournisseur.setNumTel(fournisseurDto.getNumTel());
		fournisseur.setIdEntreprise(fournisseurDto.getIdEntreprise());
		return  fournisseur;
}

}
