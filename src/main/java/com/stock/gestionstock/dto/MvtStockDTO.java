package com.stock.gestionstock.dto;

import com.stock.gestionstock.model.MvtStock;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MvtStockDTO {
	private Integer id;
	private Instant dateMvt;
	private BigDecimal quantite;
	private ArticleDTO article;
	private Integer idEntreprise;

	public static MvtStockDTO fromEntity(MvtStock mvtstock){
		if(mvtstock==null){
			return null;
		}return MvtStockDTO.builder().id(mvtstock.getId())
										.dateMvt(mvtstock.getDateMvt())
										.quantite(mvtstock.getQuantite())
										.article(ArticleDTO.fromEntity(mvtstock.getArticle()))
										.idEntreprise(mvtstock.getIdEntreprise())
										.build();
	}
public static MvtStock  toEntity(MvtStockDTO mvtStockDto){
		MvtStock mvtstock =new MvtStock();
		mvtstock.setId(mvtStockDto.getId());
		mvtstock.setDateMvt(mvtStockDto.getDateMvt());
		mvtstock.setQuantite(mvtStockDto.getQuantite());
		mvtstock.setArticle(ArticleDTO.toEntity(mvtStockDto.getArticle()));
		mvtstock.setIdEntreprise(mvtStockDto.getIdEntreprise());
		return mvtstock;
}

}
