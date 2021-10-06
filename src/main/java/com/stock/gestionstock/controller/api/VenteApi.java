package com.stock.gestionstock.controller.api;
import com.stock.gestionstock.dto.VenteDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.stock.gestionstock.utils.Constants.VENTE_ENDPOINT;

@Api(VENTE_ENDPOINT)
public interface VenteApi {
    @PostMapping(VENTE_ENDPOINT+"/create")
    VenteDTO save(@RequestBody VenteDTO dto);

    @GetMapping(VENTE_ENDPOINT+"/{idvente}")
    VenteDTO findById(@PathVariable("idvente") Integer id);


    @GetMapping(VENTE_ENDPOINT+"/all")
    List<VenteDTO> findAll();


    @DeleteMapping(VENTE_ENDPOINT+"/delete/{idvente}")
    void delete(@PathVariable("idvente") Integer id);
}
