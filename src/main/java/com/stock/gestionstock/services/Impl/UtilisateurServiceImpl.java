package com.stock.gestionstock.services.Impl;

import com.stock.gestionstock.dto.ChangerMotDePasseDTO;
import com.stock.gestionstock.dto.UtilisateurDTO;
import com.stock.gestionstock.exception.EntityNotFoundException;
import com.stock.gestionstock.exception.ErrorsCodes;
import com.stock.gestionstock.exception.InvalidEntityException;
import com.stock.gestionstock.model.Utilisateur;
import com.stock.gestionstock.repository.UtilisateurRepository;
import com.stock.gestionstock.services.UtilisateurService;
import com.stock.gestionstock.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }


    @Override
    public UtilisateurDTO save(UtilisateurDTO dto) {
        List<String> error= UtilisateurValidator.validate(dto);
        //si l'utilisateur n'est pas valide , enleve une exception de type EntityException (avec un message,un code d'errors,liste des errors,
        if(error.isEmpty()){
            log.error("utilisateur is not valide",dto);
            throw new InvalidEntityException("utilisateur n'est pas validé", ErrorsCodes.UTILISATEUR_NOT_FOUND,error);
        }
        return UtilisateurDTO.fromEntity(utilisateurRepository.save(UtilisateurDTO.toEntity(dto)));
    }



    @Override
    public UtilisateurDTO findById(Integer id) {
        if (id==null){
            log.error("utilisateur ID is null");
            return null;}
        Optional<Utilisateur> utilisateur=utilisateurRepository.findById(id);
        return Optional.of(UtilisateurDTO.fromEntity(utilisateur.get())).orElseThrow(()->
                new EntityNotFoundException( "Aucun utilisateur n'est été enregistrer dans la base de donnée",
                        ErrorsCodes.UTILISATEUR_NOT_FOUND)
        );
    }



    @Override
    public List<UtilisateurDTO> findAll() {
        //appel a la methode findAll() en envoyant une liste en utilisant la methode stream()
        return utilisateurRepository.findAll().stream()
                //faire un mapping map(methode reference)
                //detecter autaumatiquement le type de parametre (expression lamda)
                .map(UtilisateurDTO::fromEntity)
                //parser dans une liste
                .collect(Collectors.toList());
    }




    @Override
    public void delete(Integer id) {
     if(id==null){
        log.error("Utilisateur ID is null");
    }
    utilisateurRepository.deleteById(id);
}




    @Override
    public UtilisateurDTO findByEmail(String email) {
        return utilisateurRepository.findByEmail(email)
                .map(UtilisateurDTO::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun utilisateur avec l'email = " + email + " n' ete trouve dans la BDD",
                        ErrorsCodes.UTILISATEUR_NOT_FOUND)
                );
    }




    @Override
    public void changerMotDePasse(ChangerMotDePasseDTO changerMotDePasseDTO) {
        if (changerMotDePasseDTO == null) {
            log.warn("Impossible de modifier le mot de passe avec un objet NULL");
            throw new InvalidEntityException("Aucune information n'a ete fourni pour pouvoir changer le mot de passe",
                    ErrorsCodes.UTILISATEUR_NOT_FOUND);
        }
        if (changerMotDePasseDTO.getId() == null) {
            log.warn("Impossible de modifier le mot de passe avec un ID NULL");
            throw new InvalidEntityException("ID utilisateur null:: Impossible de modifier le mote de passe",
                    ErrorsCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
        if (!StringUtils.hasLength(changerMotDePasseDTO.getMotDePasse()) ||
                !StringUtils.hasLength(changerMotDePasseDTO.getConfirmMotDePasse())) {
            log.warn("Impossible de modifier le mot de passe avec un mot de passe NULL");
            throw new InvalidEntityException("Mot de passe utilisateur null:: Impossible de modifier le mote de passe",
                    ErrorsCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
        if (!changerMotDePasseDTO.getMotDePasse().equals(changerMotDePasseDTO.getConfirmMotDePasse())) {
            log.warn("Impossible de modifier le mot de passe avec deux mots de passe different");
            throw new InvalidEntityException("Mots de passe utilisateur non conformes:: Impossible de modifier le mote de passe",
                    ErrorsCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
    }
}


