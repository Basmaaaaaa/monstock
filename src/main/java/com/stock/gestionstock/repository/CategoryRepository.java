package com.stock.gestionstock.repository;

import com.stock.gestionstock.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category ,Integer> {
    Optional<Category> findArticleByCodeArticle(String code);

    //Optional<Category> findByIdAndIdEntreprise(Integer id,Integer idEntreprise);

}
