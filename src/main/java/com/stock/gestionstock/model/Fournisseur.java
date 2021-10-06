package com.stock.gestionstock.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Table(name="Fournisseur")
public class Fournisseur extends AbstructEntity {
	@Column(name="id")
	private Integer id;

	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="mail")
	private String mail;
	
	//private String adresse;
	@Embedded
	private Adresse adresse;
	@Column(name="numTel")
	private String numTel;
	
	@OneToMany(mappedBy="fournisseur")
	private List<CommandeFournisseur> commandeFournisseurs;

	@Column(name = "identreprise")
	private Integer idEntreprise;


}
