package com.stock.gestionstock.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Table(name="Client")
public class Client extends AbstructEntity {
	@Column(name="idClient")
	private Integer idClient;

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
	
	@OneToMany(mappedBy="client")
	private List<CommandeClient> commandeClients;

	@Column(name = "identreprise")
	private Integer idEntreprise;

}
