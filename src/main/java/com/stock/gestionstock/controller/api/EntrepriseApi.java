package com.stock.gestionstock.controller.api;

import com.stock.gestionstock.dto.EntrepriseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.stock.gestionstock.utils.Constants.APP_ROOT;
@Api( APP_ROOT + "/entreprises")
public interface EntrepriseApi {
    @PostMapping(value ="/entreprises/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    @ApiOperation(value = "Enregistrer des entreprises" ,
            notes = "cette methode permet d'enregistrer ou modifier une entreprise",
            response = EntrepriseDTO.class)

    @ApiResponses(value={
            @ApiResponse(code = 200, message = "l'objet entreprise crée /modifiée"),
            @ApiResponse(code = 400, message = "l'objet entreprise n'est pas valide")
    })
   ResponseEntity<EntrepriseDTO>  save(@RequestBody EntrepriseDTO dto);


    @GetMapping(value= "/entreprises/{identreprise}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher des entreprises" ,
            notes = "cette methode permet de chercher une entreprise par son ID",
            response = EntrepriseDTO.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "l'objet entreprise crée /modifiée"),
            @ApiResponse(code = 404, message = "l'objet entreprise n'est pas valide")
    })
    ResponseEntity<EntrepriseDTO> findById(@PathVariable("identreprise") Integer id);


    @GetMapping(value= "/entreprises/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste  des entreprise" ,
            notes = "cette methode permet de chercher une entrepris par son ID",
            response = EntrepriseDTO.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "la liste des entreprise/liste vide")
    })
    ResponseEntity<List<EntrepriseDTO>> findAll();


    @DeleteMapping(value= "/entreprises/delete/idEntreprise", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Supprimer une entreprise" ,
            notes = "cette methode permet de supprimer une entreprise par son ID",
            response = EntrepriseDTO.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "entreprise a ete supprimée")
    })
   public ResponseEntity delete(@PathVariable("idEntreprise") Integer idEntreprise);}
