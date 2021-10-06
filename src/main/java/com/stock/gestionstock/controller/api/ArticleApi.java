package com.stock.gestionstock.controller.api;

import com.stock.gestionstock.dto.ArticleDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.stock.gestionstock.utils.Constants.APP_ROOT;
@Api( APP_ROOT + "/articles")

public interface ArticleApi {

    //mapping
    //pour enregistrer un article c'est la methode post avec l'URL
    //consommer et produire un JSON
    @PostMapping(value ="/articles/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    @ApiOperation(value = "Enregistrer des articles" ,
            notes = "cette methode permet d'enregistrer ou modifier un article",
            response = ArticleDTO.class)

    @ApiResponses(value={
            @ApiResponse(code = 200, message = "l'objet article crée /modifiée"),
            @ApiResponse(code = 400, message = "l'objet article n'est pas valide")
    })
     ResponseEntity<ArticleDTO> save(@RequestBody ArticleDTO articleDto);


    @GetMapping(value= "/articles/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher des articles" ,
            notes = "cette methode permet de chercher un article par son ID",
            response = ArticleDTO.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "l'objet article crée /modifiée"),
            @ApiResponse(code = 404, message = "l'objet article n'est pas valide")
    })
    ResponseEntity<ArticleDTO> findById(@PathVariable("idArticle") Integer id);



    @GetMapping(value= "/articles/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher des articles" ,
            notes = "cette methode permet de chercher un article par son ID",
            response = ArticleDTO.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "l'objet article crée /modifiée"),
            @ApiResponse(code = 404, message = "l'objet article n'est pas valide")
    })
   ResponseEntity<ArticleDTO> findByCodeArticle(@PathVariable("codeArticle") String codeArticle);



    @GetMapping(value= "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste  des articles" ,
            notes = "cette methode permet de chercher une article par son ID",
            response = ArticleDTO.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "la liste des articles/liste vide")
    })
   ResponseEntity<List<ArticleDTO>>  findAll();


    @DeleteMapping(value= "/articles/delete/idArticle", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Supprimer un article" ,
            notes = "cette methode permet de supprimer un article par son ID",
            response = ArticleDTO.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "article a ete supprimée")
    })
  public  ResponseEntity delete(@PathVariable("idArticle") Integer idArticle);
}
