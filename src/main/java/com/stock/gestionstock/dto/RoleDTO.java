package com.stock.gestionstock.dto;

import com.stock.gestionstock.model.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleDTO {
	private Integer id;
	private String Rolename;
	private UtilisateurDTO utilisateur;
	private Integer idEntreprise;
	public  static RoleDTO fromEntity(Role role){
		if(role==null){
			return null;
		}
		return RoleDTO.builder().id(role.getId())
								.Rolename(role.getRolename())
								.utilisateur(UtilisateurDTO.fromEntity(role.getUtilisateur()))
								.idEntreprise(role.getIdEntreprise())
								.build();
	}
	public static Role toEntity(RoleDTO roleDto){
		Role role=new Role();
		role.setId(roleDto.getId());
		role.setRolename(roleDto.getRolename());
		role.setUtilisateur(UtilisateurDTO.toEntity(roleDto.getUtilisateur()));
		role.setIdEntreprise(roleDto.getIdEntreprise());
		return role;
	}
}
