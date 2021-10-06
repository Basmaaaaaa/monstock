package com.stock.gestionstock.services.Impl;

import com.stock.gestionstock.dto.EntrepriseDTO;
import com.stock.gestionstock.exception.EntityNotFoundException;
import com.stock.gestionstock.exception.ErrorsCodes;
import com.stock.gestionstock.exception.InvalidEntityException;
import com.stock.gestionstock.model.Entreprise;
import com.stock.gestionstock.repository.EntrepriseRepository;
import com.stock.gestionstock.services.EntrepriseService;
import com.stock.gestionstock.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {
    @Autowired
    private EntrepriseRepository entrepriseRepository;
    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }



    @Override
    public EntrepriseDTO save(EntrepriseDTO dto) {
        List<String> error= EntrepriseValidator.Validate(dto);
        //si l'entreprise n'est pas valide , enleve une exception de type EntityException (avec un message,un code d'errors,liste des errors,
        if(error.isEmpty()){
            log.error("entreprise is not valide",dto);
            throw new InvalidEntityException("l'entreprise n'est pas validé", ErrorsCodes.ENTREPRISE_NOT_VALID,error);
        }
        return EntrepriseDTO.fromEntity(entrepriseRepository.save(EntrepriseDTO.toEntity(dto)));
    }



    @Override
    public EntrepriseDTO findById(Integer id) {
        if (id==null){
            log.error("entreprise ID is null");
            return null;}
        Optional<Entreprise> entreprise=entrepriseRepository.findById(id);
        return Optional.of(EntrepriseDTO.fromEntity(entreprise.get())).orElseThrow(()->
                new EntityNotFoundException( "Aucun entreprise n'est été enregistrer dans la base de donnée",
                        ErrorsCodes.ENTREPRISE_NOT_FOUND)
        );
    }



    @Override
    public List<EntrepriseDTO> findAll() {
        //appel a la methode findAll() en envoyant une liste en utilisant la methode stream()
        return entrepriseRepository.findAll().stream()
                //faire un mapping map(methode reference)
                //detecter autaumatiquement le type de parametre (expression lamda)
                .map(EntrepriseDTO::fromEntity)
                //parser dans une liste
                .collect(Collectors.toList());
    }



    @Override
    public void delete(Integer id) {
        if(id==null){
            log.error("Article ID is null");
        }
        entrepriseRepository.deleteById(id);
    }
}
