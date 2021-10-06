package com.stock.gestionstock.controller.api;
import com.stock.gestionstock.dto.CommandeFournisseurDTO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.stock.gestionstock.utils.Constants.*;

@Api(COMMANDE_FOURNISSEUR_ENDPOINT)
public interface CommandeFournisseurApi {
    @PostMapping(CREATE_COMMANDE_FOURNISSEUR_ENDPOINT)
    ResponseEntity<CommandeFournisseurDTO> save(@RequestBody CommandeFournisseurDTO dto);

    @GetMapping (FIND_COMMANDE_FOURNISSEUR_BY_ID_ENDPOINT)
    ResponseEntity<CommandeFournisseurDTO> findById(@PathVariable("idCommandeFournisseur") Integer id);


    @GetMapping(FIND_ALL_COMMANDE_FOURNISSEUR_NDPOINT)
    ResponseEntity<List<CommandeFournisseurDTO>> findAll();

    @DeleteMapping(DELETE_COMMADE_FOURNISSEUR_ENDPOINT)
    public ResponseEntity delete(@PathVariable("idCommandeFournisseur") Integer id);
}
