package com.stock.gestionstock.services.auth;

import com.stock.gestionstock.model.Utilisateur;
import com.stock.gestionstock.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
    @Autowired
    private UtilisateurRepository service;
    @Override
    //on va charger l'user par son email
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Utilisateur> utilisateur=service.findByEmail(email);
        return new User(utilisateur.get().getEmail(),
                utilisateur.get().getPassword(),
                Collections.emptyList());
    }
}
