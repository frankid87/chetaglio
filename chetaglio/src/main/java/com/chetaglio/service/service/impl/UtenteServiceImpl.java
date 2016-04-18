package com.chetaglio.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chetaglio.model.dao.UtenteDAO;
import com.chetaglio.model.entity.Utente;
import com.chetaglio.service.service.UtenteService;

@Service
public class UtenteServiceImpl implements UtenteService{

	@Autowired
	private UtenteDAO utenteDAO;

	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void create(Utente utente){
		utenteDAO.create(utente);
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void update(Utente utente) {
		utenteDAO.update(utente);
	}


	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void delete(Utente utente) {
		utenteDAO.delete(utente);
	}

	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Utente findById(Long id) {
		return utenteDAO.findById(id);
	}

	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Utente> findAll() {
		return utenteDAO.findAll();
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Utente findByUsername(String username){
		return utenteDAO.findByUsername(username);
	}
	
}