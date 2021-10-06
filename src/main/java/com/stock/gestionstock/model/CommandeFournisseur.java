package com.stock.gestionstock.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Table(name="CommandeFournisseur")
public class CommandeFournisseur extends AbstructEntity{
	@Column(name="code")
	private String code;
	
	@Column(name="dateCommande")
	private Instant dateCommande;
	
	@ManyToOne
	@JoinColumn(name="idFournisseur")
	private Fournisseur fournisseur;
	
	@OneToMany(mappedBy="commandefournisseur")
	private List<LigneCommandeFournisseur> ligneCommanceFournisseur;

	@Column(name = "identreprise")
	private Integer idEntreprise;

	@Column(name = "etatcommande")
	@Enumerated(EnumType.STRING)
	private EtatCommande etatCommande;
}
