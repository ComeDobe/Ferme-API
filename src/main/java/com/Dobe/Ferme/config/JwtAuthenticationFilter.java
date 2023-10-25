package com.Dobe.Ferme.config;

import com.Dobe.Ferme.repositories.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.persistence.EntityNotFoundException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final  JwtUtils jwtUtils;
    private UtilisateurRepository utilisateurRepository;
    private static final String AUTHORAZITION = "Authorization";
    private static final String BEARER = "Bearer ";
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader(AUTHORAZITION);
        String utilisateurEmail ;
        String jwt ;

        if (authHeader == null || !authHeader.startsWith(BEARER)) {
            filterChain.doFilter(request, response);
            return;
        }

        jwt = authHeader.substring(7);
        utilisateurEmail = jwtUtils.extractUsername(jwt);
        if (utilisateurEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = utilisateurRepository.findByEmail(utilisateurEmail)
                    .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé lors de la validation du JWT"));
            if (jwtUtils.isTokenValid(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                        = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }

}
