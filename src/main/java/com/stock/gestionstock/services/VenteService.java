package com.stock.gestionstock.services;

import com.stock.gestionstock.dto.VenteDTO;

import java.util.List;

public interface VenteService {
    VenteDTO save(VenteDTO dto);

    VenteDTO findById(Integer id);

    List<VenteDTO> findAll();

    void delete(Integer id);


}
