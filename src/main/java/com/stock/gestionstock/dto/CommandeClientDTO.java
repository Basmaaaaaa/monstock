package com.stock.gestionstock.dto;
import com.stock.gestionstock.model.CommandeClient;
import com.stock.gestionstock.model.EtatCommande;
import lombok.Builder;
import lombok.Data;
import java.time.Instant;
import java.util.List;

@Builder
@Data
public class CommandeClientDTO {
	private Integer id;
	private String code;
	private Instant dateCommande;
	private ClientDTO client;
	private EtatCommande etatCommande;
	private Integer idEntreprise;
	private List<LigneCommandeClientDTO> ligneCommandeClients;
public  static CommandeClientDTO fromEntity(CommandeClient commandeclient){
	if(commandeclient==null){
		return null;
	}
	return CommandeClientDTO.builder().id(commandeclient.getId())
										.code(commandeclient.getCode())
										.dateCommande(commandeclient.getDateCommande())
										.client(ClientDTO.fromEntity(commandeclient.getClient()))
										.idEntreprise(commandeclient.getIdEntreprise())
										.etatCommande(commandeclient.getEtatCommande())
										.build();

}
public  static CommandeClient toEntity(CommandeClientDTO commandeclientDto){
	CommandeClient commandeclient = new CommandeClient();
	commandeclient.setId(commandeclientDto.getId());
	commandeclient.setCode(commandeclientDto.getCode());
	commandeclient.setDateCommande(commandeclientDto.getDateCommande());
	commandeclient.setClient(ClientDTO.toEntity(commandeclientDto.getClient()));
	commandeclient.setIdEntreprise(commandeclientDto.getIdEntreprise());
	commandeclient.setEtatCommande(commandeclientDto.getEtatCommande());
	return commandeclient;
}
}
