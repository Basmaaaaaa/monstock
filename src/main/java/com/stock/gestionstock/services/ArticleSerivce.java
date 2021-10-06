package com.stock.gestionstock.services;

import com.stock.gestionstock.dto.ArticleDTO;

import java.util.List;

public interface ArticleSerivce{
    ArticleDTO save(ArticleDTO articleDto);
    ArticleDTO findById(Integer id);
    ArticleDTO findByCodeArticle(String codeArticle);
    List<ArticleDTO> findAll();
    void delete(Integer id);
}
