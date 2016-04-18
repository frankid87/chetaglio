package com.chetaglio.service.service;

import java.util.List;

import com.chetaglio.model.entity.Servizio;

public interface ServizioService {

	public void create(Servizio servizio);

	public void update(Servizio servizio);

	public void delete(Servizio servizio);

	public Servizio findById(Long id);

	public List<Servizio> findAll();

}
