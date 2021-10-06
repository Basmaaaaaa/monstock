package com.stock.gestionstock.controller;
import com.stock.gestionstock.controller.api.VenteApi;
import com.stock.gestionstock.dto.VenteDTO;
import com.stock.gestionstock.services.VenteService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VenteController implements VenteApi {
    private VenteService venteService;


    @Override
    public VenteDTO save(VenteDTO dto) {
        return venteService.save(dto);
    }

    @Override
    public VenteDTO findById(Integer id) {
        return venteService.findById(id);
    }

    @Override
    public List<VenteDTO> findAll() {
        return venteService.findAll();
    }

    @Override
    public void delete(Integer id) {
        venteService.delete(id);
    }
}
