package com.stock.gestionstock.controller;

import com.stock.gestionstock.controller.api.EntrepriseApi;
import com.stock.gestionstock.dto.EntrepriseDTO;
import com.stock.gestionstock.services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class EntrepriseController implements EntrepriseApi {
    @Autowired
    private EntrepriseService entrepriseService;

    @Override
    public ResponseEntity<EntrepriseDTO> save(EntrepriseDTO dto) {
        return ResponseEntity.ok(entrepriseService.save(dto));
    }

    @Override
    public ResponseEntity<EntrepriseDTO> findById(Integer id) {
        return ResponseEntity.ok(entrepriseService.findById(id));
    }

    @Override
    public ResponseEntity<List<EntrepriseDTO>> findAll() {
        return ResponseEntity.ok(entrepriseService.findAll());
    }

    @Override
    public ResponseEntity delete(Integer idEntreprise) {
        return ResponseEntity.ok().build();
    }
}
