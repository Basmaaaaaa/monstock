 package com.stock.gestionstock.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Table(name="MvtStock")
public class MvtStock extends AbstructEntity {
	@Column(name = "idMvtStock")
	private Integer id;

	@JoinColumn(name="datemvt")
	private Instant dateMvt;
	
	@JoinColumn(name="quantite")
	private BigDecimal quantite;

	@ManyToOne
	@JoinColumn(name="article")
	private Article article;


	@Column(name = "typemvt")
	@Enumerated(EnumType.STRING)
	private TypeMvtStock typeMvt;

	@Column(name = "identreprise")
	private Integer idEntreprise;

}
