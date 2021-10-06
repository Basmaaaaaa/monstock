package com.stock.gestionstock.dto;

import com.stock.gestionstock.model.Role;
import com.stock.gestionstock.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class UtilisateurDTO {
	
	private Integer id;
	private String nom;
	private String prenom;
	private String email;
	private Instant dateNaissance;
	private AdresseDTO adresse;
	private String photo;
	private String password;
	private EntrepriseDTO entreprise;
	private List<Role> role;

	public static UtilisateurDTO fromEntity(Utilisateur utilisateur){
		if(utilisateur==null){
			return null;
		}return UtilisateurDTO.builder().id(utilisateur.getId())
										.nom(utilisateur.getNom())
										.prenom(utilisateur.getPrenom())
										.email(utilisateur.getEmail())
										.dateNaissance(utilisateur.getDateNaissance())
										.adresse(AdresseDTO.fromEntity(utilisateur.getAdresse()))
										.photo(utilisateur.getPhoto())
										.password(utilisateur.getPassword())
										.entreprise(EntrepriseDTO.fromEntity(utilisateur.getEntreprise()))
										//.role(
										//utilisateur.getRole() != null ?
										//utilisateur.getRole().stream()
										//.map(RoleDTO::fromEntity)
										//.collect(Collectors.toList()) : null)
										.build();
	}
	public static Utilisateur toEntity(UtilisateurDTO utilisateurDto){
		Utilisateur utilisateur =new Utilisateur();
		utilisateur.setId(utilisateurDto.getId());
		utilisateur.setNom(utilisateur.getNom());
		utilisateur.setPrenom(utilisateurDto.getPrenom());
		utilisateur.setEmail(utilisateur.getEmail());
		utilisateur.setDateNaissance(utilisateurDto.getDateNaissance());
		utilisateur.setAdresse(AdresseDTO.toEntity(utilisateurDto.getAdresse()));
		utilisateur.setPhoto(utilisateurDto.getPhoto());
		utilisateur.setPassword(utilisateurDto.getPassword());
		utilisateur.setEntreprise(EntrepriseDTO.toEntity(utilisateurDto.getEntreprise()));

		return utilisateur;
	}
}
