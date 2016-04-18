package com.chetaglio.model.dao;

import java.util.List;

import com.chetaglio.model.entity.Servizio;

public interface ServizioDAO {

	public void create(Servizio servizio);

	public void update(Servizio servizio);

	public void delete(Servizio servizio);

	public Servizio findById(Long id);

	public List<Servizio> findAll();

}
