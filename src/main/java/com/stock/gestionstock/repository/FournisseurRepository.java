package com.stock.gestionstock.repository;

import com.stock.gestionstock.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FournisseurRepository extends JpaRepository<Fournisseur,Integer> {
    Optional<Fournisseur> findFournisseurById(Integer id);
}
