package com.stock.gestionstock.services;

import com.stock.gestionstock.dto.FournisseurDTO;

import java.util.List;

public interface FournisseurService {
    FournisseurDTO save(FournisseurDTO dto);

    FournisseurDTO findById(Integer id);

    List<FournisseurDTO> findAll();

    void delete(Integer id);

}
