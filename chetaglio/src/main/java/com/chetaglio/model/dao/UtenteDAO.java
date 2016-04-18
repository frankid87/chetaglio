package com.chetaglio.model.dao;

import java.util.List;

import com.chetaglio.model.entity.Utente;

public interface UtenteDAO {

	public void create(Utente utente);

	public void update(Utente utente);

	public void delete(Utente utente);
	
	public Utente findById(Long id);

	public List<Utente> findAll();
	
	public Utente findByUsername(String username);
	
}
