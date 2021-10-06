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
@Table(name="Utilisateur")
public class Utilisateur extends AbstructEntity {
    @Column(name="id")
    private Integer id;

    @Column(name="nom")
	private String nom;
    
    @Column(name="prenom")
    private String prenom;
    
    @Column(name="email")
    private String email;

    @Column(name="motDePasse")
    private String motDePasse;
    
    @Column(name="dateNaissance")
    private Instant dateNaissance;
    
    @Embedded
    private Adresse adresse;
    
    @Column(name="photo")
    private String photo;
    
    @Column(name="pasword")
    private String password;
    

    @ManyToOne
    @JoinColumn(name = "identreprise")
    private Entreprise entreprise;
    
    @OneToMany(mappedBy="utilisateur")
    private List<Role> role;


}
