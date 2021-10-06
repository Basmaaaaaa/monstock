package com.stock.gestionstock.controller;

import com.stock.gestionstock.controller.api.ArticleApi;
import com.stock.gestionstock.dto.ArticleDTO;
import com.stock.gestionstock.services.ArticleSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class   ArticleController implements ArticleApi {
    @Autowired
        private ArticleSerivce articleService;
    @Override
    public ResponseEntity<ArticleDTO> save(ArticleDTO articleDto) {
        return ResponseEntity.ok(articleService.save(articleDto));
    }

    @Override
    public ResponseEntity<ArticleDTO> findById(Integer id) {
        return ResponseEntity.ok(articleService.findById(id));
    }

    @Override
    public ResponseEntity<ArticleDTO> findByCodeArticle(String codeArticle) {
        return ResponseEntity.ok(articleService.findByCodeArticle(codeArticle));
    }

    @Override
    public ResponseEntity<List<ArticleDTO>> findAll() {
        return ResponseEntity.ok(articleService.findAll());
    }

    @Override
    public ResponseEntity delete(Integer idArticle) {
        return ResponseEntity.ok().build();
    }
}
