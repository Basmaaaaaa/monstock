package com.stock.gestionstock.services.Impl;

import com.stock.gestionstock.dto.CommandeClientDTO;
import com.stock.gestionstock.model.EtatCommande;
import com.stock.gestionstock.model.LigneCommandeClient;
import com.stock.gestionstock.repository.ArticleRepository;
import com.stock.gestionstock.repository.ClientRepository;
import com.stock.gestionstock.repository.CommandeClientRepository;
import com.stock.gestionstock.repository.LigneCommandeClientRepository;
import com.stock.gestionstock.services.CommandeClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class CommandeClientServiceImpl implements CommandeClientService {

    private CommandeClientRepository commandeClientRepository;
    private LigneCommandeClientRepository ligneCommandeClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;


  @Autowired
    public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository,
                                     ClientRepository clientRepository, ArticleRepository articleRepository,
                                     LigneCommandeClientRepository ligneCommandeClientRepository) {
        this.commandeClientRepository = commandeClientRepository;
        this.ligneCommandeClientRepository = ligneCommandeClientRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
    }


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
        if(id==null){
            log.error("Commande Client ID is null");
        }
        commandeClientRepository.delete(id);
    }

}
