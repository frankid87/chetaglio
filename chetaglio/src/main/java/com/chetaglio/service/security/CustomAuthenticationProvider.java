package com.chetaglio.service.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.chetaglio.model.entity.RuoloUtente;
import com.chetaglio.model.entity.Utente;
import com.chetaglio.service.service.UtenteService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private UtenteService utenteService;

	
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();

		Utente utente = utenteService.findByUsername(username);
		
		if (utente == null || !utente.getUsername().equalsIgnoreCase(username)) {
			throw new BadCredentialsException("Username not found.");
		}

		if (!password.equals(utente.getPassword())) {
			throw new BadCredentialsException("Wrong password.");
		}

		Collection<GrantedAuthority> authorities = buildUserAuthority(utente.getRuoli());

		return new UsernamePasswordAuthenticationToken(username, password, authorities);
	}
	
	private List<GrantedAuthority> buildUserAuthority(List<RuoloUtente> ruoliUtente) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		for (RuoloUtente ruoloUtente : ruoliUtente) {
			setAuths.add(new SimpleGrantedAuthority(ruoloUtente.getRuolo()));
		}

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(setAuths);

		return authorities;
	}
	
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}