package com.stock.gestionstock.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Table(name="Vente")
public class Vente extends AbstructEntity {

	@JoinColumn(name="code")
	private String code;
	
	@JoinColumn(name="commentaire")
	private String commentaire;
	
	@JoinColumn(name="dateVente")
	private Instant dateVente;

	@Column(name = "identreprise")
	private Integer idEntreprise;
}
