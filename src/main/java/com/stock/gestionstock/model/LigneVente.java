package com.stock.gestionstock.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Table(name="LigneVente")
public class LigneVente extends AbstructEntity {
	@ManyToOne
	@JoinColumn(name = "idVente")
	private Vente vente;

	@Column(name = "quantite")
	private BigDecimal quantite;

	@Column(name = "prixUnitaire")
	private BigDecimal prixUnitaire;

	@Column(name = "identreprise")
	private Integer idEntreprise;

}
