package com.stock.gestionstock.services.Impl;

import com.stock.gestionstock.dto.CommandeClientDTO;
import com.stock.gestionstock.model.EtatCommande;
import com.stock.gestionstock.model.LigneCommandeClient;
import com.stock.gestionstock.services.CommandeClientService;

import java.math.BigDecimal;
import java.util.List;

public class CommandeFournisseurServiceImpl implements CommandeClientService {
    @Override
    public CommandeClientDTO save(CommandeClientDTO dto) {
        return null;
    }

    @Override
    public CommandeClientDTO updateEtatCommande(Integer idCommande, EtatCommande etatCommande) {
        return null;
    }

    @Override
    public CommandeClientDTO updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, BigDecimal quantite) {
        return null;
    }

    @Override
    public CommandeClientDTO updateClient(Integer idCommande, Integer idClient) {
        return null;
    }

    @Override
    public CommandeClientDTO updateArticle(Integer idCommande, Integer idLigneCommande, Integer newIdArticle) {
        return null;
    }

    @Override
    public CommandeClientDTO deleteArticle(Integer idCommande, Integer idLigneCommande) {
        return null;
    }

    @Override
    public CommandeClientDTO findById(Integer id) {
        return null;
    }

    @Override
    public CommandeClientDTO findByCode(String code) {
        return null;
    }

    @Override
    public List<LigneCommandeClient> findAll() {
        return null;
    }

    @Override
    public List<LigneCommandeClient> findAllLignesCommandesClientByCommandeClientId(Integer idCommande) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
