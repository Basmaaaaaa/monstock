package com.stock.gestionstock.controller;

import com.stock.gestionstock.controller.api.CommandeClientApi;
import com.stock.gestionstock.dto.CommandeClientDTO;
import com.stock.gestionstock.model.EtatCommande;
import com.stock.gestionstock.model.LigneCommandeClient;
import com.stock.gestionstock.services.CommandeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
@RestController
public class CommandeClientController  implements CommandeClientApi {
    @Autowired
    private CommandeClientService commandeClientService;
    @Override
    public ResponseEntity<CommandeClientDTO> save(CommandeClientDTO dto) {
        return ResponseEntity.ok(commandeClientService.save(dto));
    }

    @Override
    public ResponseEntity<CommandeClientDTO> updateEtatCommande(Integer idCommande, EtatCommande etatCommande) {
        return ResponseEntity.ok(commandeClientService.updateEtatCommande(idCommande,etatCommande));
    }

    @Override
    public ResponseEntity<CommandeClientDTO> updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, BigDecimal quantite) {
        return ResponseEntity.ok(commandeClientService.updateQuantiteCommande(idCommande,idLigneCommande,quantite));
    }

    @Override
    public ResponseEntity<CommandeClientDTO> updateClient(Integer idCommande, Integer idClient) {
        return ResponseEntity.ok(commandeClientService.updateClient(idCommande,idClient));
    }

    @Override
    public ResponseEntity<CommandeClientDTO> updateArticle(Integer idCommande, Integer idLigneCommande, Integer newIdArticle) {
        return ResponseEntity.ok(commandeClientService.updateArticle(idCommande,idLigneCommande,newIdArticle));
    }

    @Override
    public ResponseEntity<CommandeClientDTO> deleteArticle(Integer idCommande, Integer idLigneCommande) {
        return ResponseEntity.ok(commandeClientService.deleteArticle(idCommande,idLigneCommande));
    }

    @Override
    public ResponseEntity<CommandeClientDTO> findById(Integer id) {
        return ResponseEntity.ok(commandeClientService.findById(id));
    }

    @Override
    public ResponseEntity<CommandeClientDTO> findByCode(String code) {
        return ResponseEntity.ok(commandeClientService.findByCode(code));
    }

    @Override
    public ResponseEntity<List<LigneCommandeClient>> findAll() {
        return ResponseEntity.ok(commandeClientService.findAll());
    }

    @Override
    public ResponseEntity<List<LigneCommandeClient>> findAllLignesCommandesClientByCommandeClientId(Integer idCommande) {
        return ResponseEntity.ok(commandeClientService.findAllLignesCommandesClientByCommandeClientId(idCommande));
    }

    @Override
    public ResponseEntity delete(Integer id) {
        return ResponseEntity.ok().build();
    }

}
