package com.stock.gestionstock.services;

import com.stock.gestionstock.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO save(CategoryDTO categoryDTO);
    CategoryDTO findById(Integer id);
    CategoryDTO findByCodeCategory(String code);
    List<CategoryDTO> findAll();
    void delete(Integer id);
}
