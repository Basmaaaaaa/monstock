package com.stock.gestionstock.dto;

import com.stock.gestionstock.model.Adresse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdresseDTO {

	private String adresse1;
    private String adresse2;
	private String ville;
	private String codePostale;
	private String pays;

	public  static AdresseDTO fromEntity(Adresse adresse) {
		if (adresse == null) {
			return null;
		}

		return AdresseDTO.builder()
				.adresse1(adresse.getAdresse1())
				.adresse2(adresse.getAdresse2())
				.codePostale(adresse.getCodePostal())
				.ville(adresse.getVille())
				.pays(adresse.getPaye())
				.build();
	}

	public static  Adresse toEntity(AdresseDTO adresseDto) {
		if (adresseDto == null) {
			return null;
		}
		Adresse adresse = new Adresse();
		adresse.setAdresse1(adresseDto.getAdresse1());
		adresse.setAdresse2(adresseDto.getAdresse2());
		adresse.setCodePostal(adresse.getCodePostal());
		adresse.setVille(adresseDto.getVille());
		adresse.setPaye(adresseDto.getPays());
		return adresse;
	}

}



