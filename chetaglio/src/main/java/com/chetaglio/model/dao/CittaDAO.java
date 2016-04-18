package com.chetaglio.model.dao;

import java.util.List;

import com.chetaglio.model.entity.Citta;

public interface CittaDAO {
	
	public void create(Citta citta);

	public void update(Citta citta);

	public void delete(Citta citta);
	
	public Citta findById(Long id);

	public List<Citta> findAll();

}
