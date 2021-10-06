package com.stock.gestionstock.services;
import com.stock.gestionstock.dto.CommandeFournisseurDTO;
import java.util.List;

public interface CommandeFournisseurService {
    CommandeFournisseurDTO save(CommandeFournisseurDTO dto);

    CommandeFournisseurDTO findById(Integer id);

    List<CommandeFournisseurDTO> findAll();

    void delete(Integer id);
}
