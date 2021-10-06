package com.stock.gestionstock.repository;

import com.stock.gestionstock.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommandeClientRepository extends JpaRepository<Integer, CommandeClient> {
    Optional<CommandeClient> findCommandeClientById(Integer id);
}
