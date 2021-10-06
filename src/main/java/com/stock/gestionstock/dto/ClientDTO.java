package com.stock.gestionstock.dto;

import com.stock.gestionstock.model.Client;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ClientDTO {
    private Integer idClient;
    private String nom;
    private String prenom;
    private String photo;
    private String mail;
    private AdresseDTO adresse;
    private String numTel;
    private Integer idEntreprise;

    //le mapping de ClientDTO vers l'entite client
    public static ClientDTO fromEntity(Client client){
        if(client==null){
            return null;
        }
        return ClientDTO.builder().idClient(client.getIdClient())
                                    .nom(client.getNom())
                                    .prenom(client.getPrenom())
                                    .photo(client.getPhoto())
                                    .mail(client.getMail())
                                    .adresse(AdresseDTO.fromEntity(client.getAdresse()))
                                    .numTel(client.getNumTel())
                                    .idEntreprise(client.getIdEntreprise())
                                    .build();
    }
    //DTO=data transfer object pour la communication entre l'API et l'entreprise

    public  static  Client toEntity(ClientDTO clientDto){
        Client client=new Client();
        client.setIdClient(clientDto.getIdClient());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setPhoto(clientDto.getPhoto());
        client.setMail(clientDto.getMail());
        client.setNumTel(clientDto.getNumTel());
        client.setAdresse(AdresseDTO.toEntity(clientDto.getAdresse()));
        client.setIdEntreprise(clientDto.getIdEntreprise());
        return client;
    }
}
