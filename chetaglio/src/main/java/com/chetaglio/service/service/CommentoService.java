package com.chetaglio.service.service;

import java.util.List;

import com.chetaglio.model.entity.Commento;

public interface CommentoService {

	public void create(Commento commento);

	public void update(Commento commento);

	public void delete(Commento commento);

	public Commento findById(Long id);

	public List<Commento> findAll();
	
}