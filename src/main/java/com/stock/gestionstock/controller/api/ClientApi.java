package com.stock.gestionstock.controller.api;
import com.stock.gestionstock.dto.ArticleDTO;
import com.stock.gestionstock.dto.ClientDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.stock.gestionstock.utils.Constants.APP_ROOT;
@Api(APP_ROOT+"/clients")
public interface ClientApi {
    @PostMapping(value ="/clients/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer des clients" ,
            notes = "cette methode permet d'enregistrer ou modifier un client",
            response = ClientDTO.class)
     @ApiResponses(value={
            @ApiResponse(code = 200, message = "l'objet client crée /modifiée"),
            @ApiResponse(code = 400, message = "l'objet client n'est pas valide")
    })
    ResponseEntity<ClientDTO> save(@RequestBody ClientDTO clientDTO);


    @GetMapping(value= "/clients/{idClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher des clients" ,
            notes = "cette methode permet de chercher un client par son ID",
            response = ClientDTO.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "l'objet client crée /modifiée"),
            @ApiResponse(code = 404, message = "l'objet client n'est pas valide")
    })
    ResponseEntity<ClientDTO>  findById(@PathVariable("idClient") Integer id);





    @GetMapping(value= "/clients/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste  des clients" ,
            notes = "cette methode permet de chercher une client par son ID",
            response = ClientDTO.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "la liste des clients/liste vide")
    })
    ResponseEntity<List<ClientDTO>> findAll();


    @DeleteMapping(value= "/clients/delete/idclient", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Supprimer un client" ,
            notes = "cette methode permet de supprimer un client par son ID",
            response = ArticleDTO.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "client a ete supprimée")
    })
  public ResponseEntity delete(Integer idClient);
}
