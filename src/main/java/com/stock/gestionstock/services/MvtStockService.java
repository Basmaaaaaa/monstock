package com.stock.gestionstock.services;

import com.stock.gestionstock.dto.MvtStockDTO;

import java.math.BigDecimal;
import java.util.List;

public interface MvtStockService {
    BigDecimal stockReelArticle(Integer idArticle);

    List<MvtStockDTO> mvtStkArticle(Integer idArticle);

    MvtStockDTO entreeStock(MvtStockDTO mvtStockDTO);

    MvtStockDTO sortieStock(MvtStockDTO mvtStockDTO);

    MvtStockDTO correctionStockPos(MvtStockDTO mvtStockDTOo);

    MvtStockDTO correctionStockNeg(MvtStockDTO mvtStockDTO);
}
