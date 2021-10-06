package com.stock.gestionstock.controller;

import com.stock.gestionstock.controller.api.ClientApi;
import com.stock.gestionstock.dto.ClientDTO;
import com.stock.gestionstock.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ClientController implements ClientApi {
    @Autowired
    private ClientService clientService;

    @Override
    public ResponseEntity<ClientDTO> save(ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.save(clientDTO));
    }

    @Override
    public ResponseEntity<ClientDTO> findById(Integer id) {
        return ResponseEntity.ok(clientService.findById(id));
    }

    @Override
    public ResponseEntity<List<ClientDTO>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @Override
    public ResponseEntity delete(Integer idClient) {
        return ResponseEntity.ok().build();
    }
}
