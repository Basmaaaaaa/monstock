package com.stock.gestionstock.controller;

import com.stock.gestionstock.controller.api.UtilisateurApi;
import com.stock.gestionstock.dto.UtilisateurDTO;
import com.stock.gestionstock.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtilisateurController implements UtilisateurApi {

    private UtilisateurService utilisateurService;
    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Override
    public UtilisateurDTO save(UtilisateurDTO dto) {
        return utilisateurService.save(dto);
    }

    @Override
    public UtilisateurDTO findById(Integer id) {
        return utilisateurService.findById(id);
    }

    @Override
    public List<UtilisateurDTO> findAll() {
        return utilisateurService.findAll();
    }

    @Override
    public void delete(Integer id) {
            utilisateurService.delete(id);
    }
}
