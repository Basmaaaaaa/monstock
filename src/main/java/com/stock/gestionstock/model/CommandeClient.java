package com.stock.gestionstock.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Table(name="CommandeClient")
public class CommandeClient extends AbstructEntity {
	@Column(name="code")
	private String code;
	
	@Column(name="dateCommande")
	private Instant dateCommande;
	

	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	
	@OneToMany(mappedBy="commandeclient")
	private List<LigneCommandeClient> ligneCommandeClient;


	@Column(name = "identreprise")
	private Integer idEntreprise;

	@Column(name = "etatcommande")
	@Enumerated(EnumType.STRING)
	private EtatCommande etatCommande;

}
