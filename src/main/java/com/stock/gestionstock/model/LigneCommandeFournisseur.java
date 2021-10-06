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
@Table(name="LigneCommandeFournisseur")
public class LigneCommandeFournisseur extends AbstructEntity {
    @Column(name = "idLigneCommandeFournisseur")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="idArticle")
	private Article article;
    
    @ManyToOne
    @JoinColumn(name="idCommandeFournisseur")
    private CommandeFournisseur commandeFournisseurs;

    @Column(name = "identreprise")
    private Integer idEntreprise;


}
