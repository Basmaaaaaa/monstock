package com.stock.gestionstock.repository;

import com.stock.gestionstock.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository< Client,Integer> {
    Optional<Client> findArticleByIdArticle(Integer id);
}
