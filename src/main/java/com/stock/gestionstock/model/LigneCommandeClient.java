package com.stock.gestionstock.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Table(name="LigneCommandeClient")
public class LigneCommandeClient extends AbstructEntity {
	@Column(name="code")
	private String code;

	@ManyToOne
	@JoinColumn(name="idArticle")
	private Article article;
	
	@ManyToOne
	@JoinColumn(name="idCommandeClient")
	private CommandeClient commandeClient;


	@Column(name="quantite")
	private BigDecimal quantite;


	@Column(name="prixUnitaire")
	private BigDecimal prixUnitaire;

	@Column(name = "identreprise")
	private Integer idEntreprise;

	@OneToMany(mappedBy = "commandeClient")
	private List<LigneCommandeClient> ligneCommandeClients;

}
