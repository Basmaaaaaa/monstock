package com.stock.gestionstock.repository;

import com.stock.gestionstock.model.Article;
import com.stock.gestionstock.model.CommandeClient;
import com.stock.gestionstock.model.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient,Integer> {
    Optional<LigneCommandeClient> FindLigneCommandeClientBycode(String code);
    List<Article> findAllByIdArticle(String code);
    List<CommandeClient> findAllByCodeCommandeClient(String code);
}
