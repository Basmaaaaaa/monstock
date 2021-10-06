package com.stock.gestionstock.repository;

import com.stock.gestionstock.model.Role;
import com.stock.gestionstock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {

    Optional<Utilisateur> findById(Integer id);
    Optional<Utilisateur> findByEmail(String email);
    List<Role> findAllByIdRole(Integer id);
}
