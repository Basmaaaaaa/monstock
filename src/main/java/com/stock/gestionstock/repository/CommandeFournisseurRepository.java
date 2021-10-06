package com.stock.gestionstock.repository;

import com.stock.gestionstock.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommandeFournisseurRepository extends JpaRepository< CommandeFournisseur,Integer> {
    Optional<CommandeFournisseur> findCommandeFournisseurBycodeFournisseur(String code);
}
