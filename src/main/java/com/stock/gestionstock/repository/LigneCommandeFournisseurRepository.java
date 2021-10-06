package com.stock.gestionstock.repository;

import com.stock.gestionstock.model.Article;
import com.stock.gestionstock.model.CommandeFournisseur;
import com.stock.gestionstock.model.LigneCommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LigneCommandeFournisseurRepository extends JpaRepository<LigneCommandeFournisseur,Integer> {

    Optional<LigneCommandeFournisseur> findById(Integer id);
    List<Article> findAllByIdcodeArticle(String code);
    List<CommandeFournisseur> findAllByIdcodeCommandeFournisseur(String code);
}
