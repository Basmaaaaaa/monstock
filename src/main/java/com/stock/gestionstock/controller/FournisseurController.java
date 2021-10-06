package com.stock.gestionstock.controller;

import com.stock.gestionstock.controller.api.FournisseurApi;
import com.stock.gestionstock.dto.FournisseurDTO;
import com.stock.gestionstock.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class FournisseurController implements FournisseurApi {

    private FournisseurService fournisseurService;
    @Autowired
    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @Override
    public FournisseurDTO save(FournisseurDTO dto) {
        return fournisseurService.save(dto);
    }

    @Override
    public FournisseurDTO findById(Integer id) {
        return fournisseurService.findById(id);
    }

    @Override
    public List<FournisseurDTO> findAll() {
        return fournisseurService.findAll();
    }

    @Override
    public void delete(Integer id) {
        fournisseurService.delete(id);
    }
}
