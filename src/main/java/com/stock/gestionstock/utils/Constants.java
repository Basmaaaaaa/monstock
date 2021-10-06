package com.stock.gestionstock.utils;

public interface Constants {
    //le chemain de base de notre API  commande fournisseur
     String APP_ROOT="APPLICATION DE GESTION DE STOCK";
     String COMMANDE_FOURNISSEUR_ENDPOINT=APP_ROOT+"/commandefournisseurs";
     String CREATE_COMMANDE_FOURNISSEUR_ENDPOINT=COMMANDE_FOURNISSEUR_ENDPOINT+"/create";
     String FIND_COMMANDE_FOURNISSEUR_BY_ID_ENDPOINT=COMMANDE_FOURNISSEUR_ENDPOINT+"/{idCommandeFournisseur}";
     String FIND_ALL_COMMANDE_FOURNISSEUR_NDPOINT=COMMANDE_FOURNISSEUR_ENDPOINT+"/all";
     String DELETE_COMMADE_FOURNISSEUR_ENDPOINT=COMMANDE_FOURNISSEUR_ENDPOINT+"/delete/{idCommandeFournisseur}";

     //le chemain de base de fournisseur API
    String FOURNISSEUR_ENDPOINT=APP_ROOT+"/fournisseurs";
    String CREATE_FOURNISSEUR_ENDPOINT=FOURNISSEUR_ENDPOINT+"/create";
    String FIND_FOURNISSEUR_BY_ID_ENDPOINT=FOURNISSEUR_ENDPOINT+"/{idFournisseur}";
    String FIND_ALL_FOURNISSEUR_ENDPOINT=FOURNISSEUR_ENDPOINT+"/all";
    String DELETE_FOURNISSEUR_ENDPOINT=FOURNISSEUR_ENDPOINT+"/delete/{idFournisseur}";


    //le chemain de base de l'API Utilisateur
    String UTILISATEUR_ENDPOINT=APP_ROOT+"/utilisateurs";
    String CREATE_UTILISATEUR_ENDPOINT=UTILISATEUR_ENDPOINT+"/create";
    String FIND_UTILISATEUR_BY_ID_ENDPOINT=UTILISATEUR_ENDPOINT+"/{idutilisateur}";
    String FIND_ALL_UTILISATEUR_ENDPOINT=UTILISATEUR_ENDPOINT+"/all";
    String DELETE_UTILISATEUR_ENDPOINT=UTILISATEUR_ENDPOINT+"/delete/{idutilisateur}";

    //le chemain de base de l'API Vente
    String VENTE_ENDPOINT=APP_ROOT+"/ventes";
    String CREATE_VENTE_ENDPOINT=VENTE_ENDPOINT+"/create";
    String FIND_VENTE_BY_ID_ENDPOINT=VENTE_ENDPOINT+"/{idvente}";
    String FIND_ALL_VENTE_ENDPOINT=VENTE_ENDPOINT+"/all";
    String DELETE_VENTE_ENDPOINT=VENTE_ENDPOINT+"/delete/{idvente}";


    //le chemain de base d'authentifier un user
    String AUTHENTIFICATE_USER_ENDPOINT=APP_ROOT+"/authentification";

}
