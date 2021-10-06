package com.stock.gestionstock.services.Impl;

import com.stock.gestionstock.dto.FournisseurDTO;
import com.stock.gestionstock.exception.EntityNotFoundException;
import com.stock.gestionstock.exception.ErrorsCodes;
import com.stock.gestionstock.exception.InvalidEntityException;
import com.stock.gestionstock.model.Fournisseur;
import com.stock.gestionstock.repository.FournisseurRepository;
import com.stock.gestionstock.services.FournisseurService;
import com.stock.gestionstock.validator.FournisseurValidate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {
    //injection par constructeur
    @Autowired
    private FournisseurRepository fournisseurRepository;
    @Autowired
    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }



    @Override
    public FournisseurDTO save(FournisseurDTO dto) {
        List<String>error= FournisseurValidate.Validate(dto);
        if(error.isEmpty()){
            log.error("fournisseur is not valide",dto);
            throw new InvalidEntityException("fournisseur n'est pas validé", ErrorsCodes.FOURNISSEUR_NOT_VALID,error);
        }
        return FournisseurDTO.fromEntity(fournisseurRepository.save(FournisseurDTO.toEntity(dto)));
    }



    @Override
    public FournisseurDTO findById(Integer id) {
        if (id==null){
            log.error("fournisseur ID is null");
            return null;}
        //si le fournisseur n'est pas enregistrer dans la BDD
        Optional<Fournisseur> fournisseur=fournisseurRepository.findById(id);
        return Optional.of(FournisseurDTO.fromEntity(fournisseur.get())).orElseThrow(()->
                new EntityNotFoundException( "Aucun fournisseur n'est été enregistrer dans la base de donnée",
                        ErrorsCodes.FOURNISSEUR_NOT_FOUND)
        );
    }


    @Override
    public List<FournisseurDTO> findAll() {
        //appel a la methode findAll() en envoyant une liste en utilisant la methode stream()
        return fournisseurRepository.findAll().stream()
                //faire un mapping map(methode reference)
                //detecter autaumatiquement le type de parametre (expression lamda)
                .map(FournisseurDTO::fromEntity)
                //parser dans une liste
                .collect(Collectors.toList());
    }



    @Override
    public void delete(Integer id) {
        if(id==null){
            log.error("Fournisseur ID is null");
        }
        fournisseurRepository.deleteById(id);

    }
}
