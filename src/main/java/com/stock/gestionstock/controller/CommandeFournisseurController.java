package com.stock.gestionstock.controller;

import com.stock.gestionstock.controller.api.CommandeFournisseurApi;
import com.stock.gestionstock.dto.CommandeFournisseurDTO;
import com.stock.gestionstock.services.CommandeFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommandeFournisseurController implements CommandeFournisseurApi {
    @Autowired
    private CommandeFournisseurService commandeFournisseurService;

    @Override
    public ResponseEntity<CommandeFournisseurDTO> save(CommandeFournisseurDTO dto) {
        return ResponseEntity.ok(commandeFournisseurService.save(dto));
    }

    @Override
    public ResponseEntity<CommandeFournisseurDTO> findById(Integer id) {
        return ResponseEntity.ok(commandeFournisseurService.findById(id));
    }

    @Override
    public ResponseEntity<List<CommandeFournisseurDTO>> findAll() {
        return ResponseEntity.ok(commandeFournisseurService.findAll());
    }

    @Override
    public ResponseEntity delete(Integer id) {

        return ResponseEntity.ok().build();
    }
}
