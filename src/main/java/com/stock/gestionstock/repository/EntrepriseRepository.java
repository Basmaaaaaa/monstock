package com.stock.gestionstock.repository;

import com.stock.gestionstock.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntrepriseRepository extends JpaRepository<Entreprise,Integer> {
    Optional<Entreprise> findEntrepriseByIdEntreprise(Integer idEntreprise);
}
