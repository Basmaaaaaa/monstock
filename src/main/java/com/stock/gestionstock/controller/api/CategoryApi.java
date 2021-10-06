package com.stock.gestionstock.controller.api;

import com.stock.gestionstock.dto.CategoryDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.stock.gestionstock.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/categories")
public interface CategoryApi {
    //mapping
    //pour enregistrer un article c'est la methode post avec l'URL
    //consommer et produire un JSON
    @PostMapping(value = "/categories/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    @ApiOperation(value = "Enregistrer des categories",
            notes = "cette methode permet d'enregistrer ou modifier une categorie",
            response = CategoryDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet categorie crée /modifiée"),
            @ApiResponse(code = 400, message = "l'objet categorie n'est pas valide")
    })
    ResponseEntity<CategoryDTO> save(@RequestBody CategoryDTO categoryDTO);


    @GetMapping(value = "/categories/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher des categories",
            notes = "cette methode permet de chercher une categorie par son ID",
            response = CategoryDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet categorie crée /modifiée"),
            @ApiResponse(code = 404, message = "l'objet categorie n'est pas valide")
    })
    ResponseEntity<CategoryDTO> findById(@PathVariable("idCategory") Integer idCategory);


    @GetMapping(value = "/categories/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher des categories",
            notes = "cette methode permet de chercher une categorie par son ID",
            response = CategoryDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet categorie crée /modifiée"),
            @ApiResponse(code = 404, message = "l'objet categorie n'est pas valide")
    })
    ResponseEntity<CategoryDTO> findByCodeCategory(@PathVariable("codeCategory") String codeCategory);


    @GetMapping(value = "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste  des categories",
            notes = "cette methode permet de chercher une categorie par son ID",
            response = CategoryDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste des categories/liste vide")
    })
    ResponseEntity<List<CategoryDTO>> findAll();


    @DeleteMapping(value = "/categories/delete/idCategory", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Supprimer une categories",
            notes = "cette methode permet de supprimer une categorie par son ID",
            response = CategoryDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "categorie a ete supprimée")
    })
    public ResponseEntity delete(Integer id);
}
