package com.stock.gestionstock.dto;

import com.stock.gestionstock.model.Vente;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class VenteDTO {
	private Integer id;
	private String code;
	private String commentaire;
	private Instant dateVente;
	private Integer idEntreprise;
	public static VenteDTO fromEntity(Vente vente){
		if(vente==null){
			return null;
		}return VenteDTO.builder().id(vente.getId())
									.code(vente.getCode())
									.commentaire(vente.getCommentaire())
									.dateVente(vente.getDateVente())
									.idEntreprise(vente.getIdEntreprise())
									.build();
	}
	public static Vente toEntity(VenteDTO venteDTO){
		Vente vente=new Vente();
		vente.setId(venteDTO.getId());
		vente.setCode(venteDTO.getCode());
		vente.setCommentaire(venteDTO.getCommentaire());
		vente.setDateVente(venteDTO.getDateVente());
		vente.setIdEntreprise(venteDTO.getIdEntreprise());
		return vente;
	}
}
