package com.stock.gestionstock.controller.api;

import com.stock.gestionstock.dto.CommandeClientDTO;
import com.stock.gestionstock.model.EtatCommande;
import com.stock.gestionstock.model.LigneCommandeClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.math.BigDecimal;
import java.util.List;

import static com.stock.gestionstock.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/commandeclients")
public interface CommandeClientApi {
    @PostMapping(value ="/commandeclients/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
     @ApiOperation(value = "Enregistrer des commandeclients" ,
            notes = "cette methode permet d'enregistrer ou modifier une commande client",
            response = CommandeClientDTO.class)
     @ApiResponses(value={
            @ApiResponse(code = 200, message = "l'objet commande client crée /modifiée"),
            @ApiResponse(code = 400, message = "l'objet commande client n'est pas valide")
    })
    ResponseEntity<CommandeClientDTO> save(CommandeClientDTO dto);


    @PostMapping(value ="/commandeclients/updateEtatCommande",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer les etats de commande clients" ,
            notes = "cette methode permet d'enregistrer ou modifier les etats de commande clients",
            response = CommandeClientDTO.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "l'objet etat de commande client crée /modifiée"),
            @ApiResponse(code = 400, message = "l'objet etat de commande client n'est pas valide")
    })
    ResponseEntity<CommandeClientDTO> updateEtatCommande(Integer idCommande, EtatCommande etatCommande);



    @PostMapping(value ="/commandeclients/updateQuantiteCommande",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer les quantites de commande clients" ,
            notes = "cette methode permet d'enregistrer ou modifier les quantites de commande clients",
            response = CommandeClientDTO.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "l'objet quantite de commande client crée /modifiée"),
            @ApiResponse(code = 400, message = "l'objet quantite de commande client n'est pas valide")
    })
    ResponseEntity<CommandeClientDTO> updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, BigDecimal quantite);


    @PostMapping(value ="/commandeclients/updateClient",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer les  clients" ,
            notes = "cette methode permet d'enregistrer ou modifier la liste des clients",
            response = CommandeClientDTO.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "l'objet  client crée /modifiée"),
            @ApiResponse(code = 400, message = "l'objet  client n'est pas valide")
    })
    ResponseEntity<CommandeClientDTO> updateClient(Integer idCommande, Integer idClient);


    @PostMapping(value ="/commandeclients/updateArticle",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer les  articles" ,
            notes = "cette methode permet d'enregistrer ou modifier la liste des articles",
            response = CommandeClientDTO.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "l'objet  client crée /modifiée"),
            @ApiResponse(code = 400, message = "l'objet  client n'est pas valide")
    })
    ResponseEntity<CommandeClientDTO> updateArticle(Integer idCommande, Integer idLigneCommande, Integer newIdArticle);



    @PostMapping(value ="/commandeclients/deleteArticle",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Supprimer les articles" ,
            notes = "cette methode permet de supprimer la liste des articles",
            response = CommandeClientDTO.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "l'objet  article supprimé"),
            @ApiResponse(code = 400, message = "l'objet  article n'est pas supprimé")
    })
    ResponseEntity<CommandeClientDTO> deleteArticle(Integer idCommande, Integer idLigneCommande);


    @PostMapping(value ="/commandeclients/findById",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer les commandes client par ID" ,
            notes = "cette methode permet d'Enregistrer les commandes client par ID'",
            response = CommandeClientDTO.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "l'objet  commande client  enregistré par ID"),
            @ApiResponse(code = 400, message = "l'objet  commande client  enregistré par ID")
    })
    ResponseEntity<CommandeClientDTO> findById(Integer id);


    @PostMapping(value ="/commandeclients/findByCode",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer les commandes client par CODE" ,
            notes = "cette methode permet d'Enregistrer les commandes client par CODE'",
            response = CommandeClientDTO.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "l'objet  commande client  enregistré par CODE"),
            @ApiResponse(code = 400, message = "l'objet  commande client n'est pas enregistré par CODE")
    })
    ResponseEntity<CommandeClientDTO> findByCode(String code);



    @PostMapping(value ="/commandeclients/findAll",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer la liste des commande clients" ,
            notes = "cette methode permet d'Enregistrer la liste des  commandes client '",
            response = CommandeClientDTO.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = " liste des  commandes client  enregistré "),
            @ApiResponse(code = 400, message = "  liste des  commandes client n'est pas enregistré ")
    })
    ResponseEntity<List<LigneCommandeClient>> findAll();


    @PostMapping(value ="/commandeclients/findAllLignesCommandesClientByCommandeClientId")
    ResponseEntity<List<LigneCommandeClient>> findAllLignesCommandesClientByCommandeClientId(Integer idCommande);

    @DeleteMapping(value ="/commandeclients/delete")
    public ResponseEntity delete(@PathVariable("idCommandeClient") Integer id);

}
