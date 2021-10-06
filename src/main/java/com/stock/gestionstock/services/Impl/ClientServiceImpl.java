package com.stock.gestionstock.services.Impl;

import com.stock.gestionstock.dto.ClientDTO;
import com.stock.gestionstock.exception.EntityNotFoundException;
import com.stock.gestionstock.exception.ErrorsCodes;
import com.stock.gestionstock.exception.InvalidEntityException;
import com.stock.gestionstock.model.Client;
import com.stock.gestionstock.repository.ClientRepository;
import com.stock.gestionstock.services.ClientService;
import com.stock.gestionstock.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        List<String> error = ClientValidator.validate(clientDTO);
        if (error.isEmpty()) {
            log.error("Client is not valide", clientDTO);
            throw new InvalidEntityException("Client n'est pas valide", ErrorsCodes.ARTICLE_NOT_VALID, error);
        }
        return ClientDTO.fromEntity(clientRepository.save(ClientDTO.toEntity(clientDTO)));
    }


    @Override
    public ClientDTO findById(Integer id) {
        if (id == null) {
            log.error("Client ID is null");
            return null;
        }
        Optional<Client> client = clientRepository.findById(id);
        return Optional.of(ClientDTO.fromEntity(client.get())).orElseThrow(() ->
                new EntityNotFoundException("Aucun client n'est été enregistrer dans la base de donnée",
                        ErrorsCodes.CLIENT_NOT_VALID));
    }


    @Override
    public List<ClientDTO> findAll() {
        //appel a la methode findAll() en envoyant une liste en utilisant la methode stream()
        return clientRepository.findAll().stream()
                //faire un mapping map(methode reference)
                //detecter autaumatiquement le type de parametre (expression lamda)
                .map(ClientDTO::fromEntity)
                //parser dans une liste
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Client ID is null");
        }
        clientRepository.deleteById(id);
        }
}