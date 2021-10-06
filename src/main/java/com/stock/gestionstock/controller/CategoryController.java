package com.stock.gestionstock.controller;

import com.stock.gestionstock.controller.api.CategoryApi;
import com.stock.gestionstock.dto.CategoryDTO;
import com.stock.gestionstock.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CategoryController implements CategoryApi {
    @Autowired
    //pour l'injection
    private CategoryService categoryService;

    @Override
    public ResponseEntity<CategoryDTO> save(CategoryDTO categoryDTO) {
        return ResponseEntity.ok(categoryService.save(categoryDTO));
    }

    @Override
    public ResponseEntity<CategoryDTO> findById(Integer idCategory) {
        return ResponseEntity.ok(categoryService.findById(idCategory));
    }

    @Override
    public ResponseEntity<CategoryDTO> findByCodeCategory(String codeCategory) {
        return ResponseEntity.ok(categoryService.findByCodeCategory(codeCategory));
    }

    @Override
    public ResponseEntity<List<CategoryDTO>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @Override
    public ResponseEntity delete(Integer id) {
        return ResponseEntity.ok().build();
    }
}
