package com.chetaglio.service.service;

import java.util.List;

import com.chetaglio.model.entity.Utente;

public interface UtenteService {
	
	public void create(Utente utente);

	public void update(Utente utente);

	public void delete(Utente utente);

	public Utente findById(Long id);

	public List<Utente> findAll();
	
	public Utente findByUsername(String username);
	
}
