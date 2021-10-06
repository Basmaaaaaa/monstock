package com.stock.gestionstock.services;

import com.stock.gestionstock.dto.EntrepriseDTO;

import java.util.List;

public interface EntrepriseService {
    EntrepriseDTO save(EntrepriseDTO dto);

    EntrepriseDTO findById(Integer id);

    List<EntrepriseDTO> findAll();

    void delete(Integer id);
}
