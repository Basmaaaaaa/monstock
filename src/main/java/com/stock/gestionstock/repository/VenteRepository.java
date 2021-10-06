package com.stock.gestionstock.repository;

import com.stock.gestionstock.model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VenteRepository extends JpaRepository<Vente,Integer> {

    Optional<Vente> findById(String code);
}
