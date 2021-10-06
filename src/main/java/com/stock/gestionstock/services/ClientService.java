package com.stock.gestionstock.services;

import com.stock.gestionstock.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    ClientDTO save(ClientDTO clientDTO);
    ClientDTO findById(Integer id);

    List<ClientDTO> findAll();
    void delete(Integer id);
}
