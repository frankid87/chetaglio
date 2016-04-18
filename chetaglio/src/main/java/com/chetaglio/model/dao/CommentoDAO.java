package com.chetaglio.model.dao;

import java.util.List;

import com.chetaglio.model.entity.Commento;

public interface CommentoDAO {
	
	public void create(Commento commento);

	public void update(Commento commento);

	public void delete(Commento commento);

	public Commento findById(Long id);

	public List<Commento> findAll();
	
}
