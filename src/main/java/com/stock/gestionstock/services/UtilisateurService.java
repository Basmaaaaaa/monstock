package com.stock.gestionstock.services;

import com.stock.gestionstock.dto.ChangerMotDePasseDTO;
import com.stock.gestionstock.dto.UtilisateurDTO;

import java.util.List;

public interface UtilisateurService {

    UtilisateurDTO save(UtilisateurDTO dto);

    UtilisateurDTO findById(Integer id);

    List<UtilisateurDTO> findAll();

    void delete(Integer id);

    UtilisateurDTO findByEmail(String email);

    void changerMotDePasse(ChangerMotDePasseDTO changerMotDePasseDTO);
}
