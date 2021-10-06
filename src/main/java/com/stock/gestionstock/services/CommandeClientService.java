package com.stock.gestionstock.services;

import com.stock.gestionstock.dto.CommandeClientDTO;
import com.stock.gestionstock.model.EtatCommande;
import com.stock.gestionstock.model.LigneCommandeClient;

import java.math.BigDecimal;
import java.util.List;

public interface CommandeClientService {
    CommandeClientDTO save(CommandeClientDTO dto);

    CommandeClientDTO updateEtatCommande(Integer idCommande, EtatCommande etatCommande);

    CommandeClientDTO updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, BigDecimal quantite);

    CommandeClientDTO updateClient(Integer idCommande, Integer idClient);

    CommandeClientDTO updateArticle(Integer idCommande, Integer idLigneCommande, Integer newIdArticle);


    CommandeClientDTO deleteArticle(Integer idCommande, Integer idLigneCommande);

    CommandeClientDTO findById(Integer id);

    CommandeClientDTO findByCode(String code);

   List<LigneCommandeClient> findAll();

    List<LigneCommandeClient> findAllLignesCommandesClientByCommandeClientId(Integer idCommande);

    void delete(Integer id);
}
