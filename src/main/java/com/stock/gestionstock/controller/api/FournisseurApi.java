package com.stock.gestionstock.controller.api;

import com.stock.gestionstock.dto.FournisseurDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.stock.gestionstock.utils.Constants.*;

@Api(FOURNISSEUR_ENDPOINT)
public interface FournisseurApi {
    @PostMapping(CREATE_COMMANDE_FOURNISSEUR_ENDPOINT+"/create")
    FournisseurDTO save(@RequestBody FournisseurDTO dto);

    @GetMapping(FIND_FOURNISSEUR_BY_ID_ENDPOINT+"/findById{idFournisseur}")
    FournisseurDTO findById(@PathVariable("idFournisseur") Integer id);

    @GetMapping(FIND_ALL_FOURNISSEUR_ENDPOINT+"/findAll")
    List<FournisseurDTO> findAll();

    @DeleteMapping(DELETE_FOURNISSEUR_ENDPOINT+"/delete{idFournisseur}")
    void delete(@PathVariable("idFournisseur") Integer id);
}
