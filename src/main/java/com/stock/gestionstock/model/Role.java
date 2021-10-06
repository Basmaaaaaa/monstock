package com.stock.gestionstock.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Table(name="Role")
public class Role  extends AbstructEntity{
	 @Column(name="Rolename")
	 private String Rolename;
	 
	 @ManyToOne
	 @JoinColumn(name="idutilisateur")
	 private Utilisateur utilisateur;

	@Column(name = "identreprise")
	private Integer idEntreprise;
}
