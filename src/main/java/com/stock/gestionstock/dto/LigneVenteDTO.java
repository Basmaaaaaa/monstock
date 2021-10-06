package com.stock.gestionstock.dto;

import com.stock.gestionstock.model.LigneVente;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Builder
public class LigneVenteDTO {
	private Integer id;
	private VenteDTO vente;
	private BigDecimal quantite;
	private BigDecimal prixUnitaire;
	private Integer idEntreprise;
	public static LigneVenteDTO fromEntity(LigneVente lignevente){
		if(lignevente==null){
			return null;
		}
		return LigneVenteDTO.builder().id(lignevente.getId())
										.vente(VenteDTO.fromEntity(lignevente.getVente()))
										.quantite(lignevente.getQuantite())
										.prixUnitaire(lignevente.getPrixUnitaire())
										.idEntreprise(lignevente.getIdEntreprise())
										.build();
	}
	public static LigneVente toEntity(LigneVenteDTO ligneventeDto){
		LigneVente lignevente=new LigneVente();
		lignevente.setId(ligneventeDto.getId());
		lignevente.setVente(VenteDTO.toEntity(ligneventeDto.getVente()));
		lignevente.setQuantite(ligneventeDto.getQuantite());
		lignevente.setPrixUnitaire(ligneventeDto.getPrixUnitaire());
		lignevente.setIdEntreprise(ligneventeDto.getIdEntreprise());
		return lignevente;
	}

}
