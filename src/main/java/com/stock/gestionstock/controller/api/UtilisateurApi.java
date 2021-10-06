package com.stock.gestionstock.controller.api;
import com.stock.gestionstock.dto.UtilisateurDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.stock.gestionstock.utils.Constants.*;

@Api(UTILISATEUR_ENDPOINT)
public interface UtilisateurApi {
    @PostMapping(CREATE_FOURNISSEUR_ENDPOINT+"create")
    UtilisateurDTO save(@RequestBody UtilisateurDTO dto);

    @GetMapping(FIND_UTILISATEUR_BY_ID_ENDPOINT+"/{idutilisateur}")
    UtilisateurDTO findById(@PathVariable("idutilisateur") Integer id);


    @GetMapping(FIND_ALL_UTILISATEUR_ENDPOINT+"/all")
    List<UtilisateurDTO> findAll();

    @DeleteMapping(DELETE_UTILISATEUR_ENDPOINT+"/delete/{idutilisateur}")
    void delete(@PathVariable("idutilisateur") Integer id);

}
