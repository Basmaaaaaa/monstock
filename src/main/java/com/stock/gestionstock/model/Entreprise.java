package com.stock.gestionstock.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Table(name="Entreprise")
public class Entreprise extends AbstructEntity {
	@Column(name = "identreprise")
	private Integer idEntreprise;

	@Column(name = "nom")
	private String nom;

    @Embedded
	private Adresse adresse;

	@Column(name="codefiscal")
    private String codeFiscal;

	@Column(name="photo")
    private String photo;

	@Column(name="email")
	private String email;

	@Column(name="description")
	private String description;

	@Column(name="numerotel")
	private String numTel;

	@Column(name="siteweb")
	private String siteWeb;

	@OneToMany(mappedBy = "entreprise")
	private List<Utilisateur> utilisateurs;


}
