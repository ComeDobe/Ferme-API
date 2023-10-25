package com.Dobe.Ferme.services.Auth;

import com.Dobe.Ferme.repositories.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UtilisateurRepository utilisateurRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return utilisateurRepository.findByEmail(email)
                .orElseThrow( () -> new EntityNotFoundException("pas d'utilisateur avec cet email"));
    }
}
