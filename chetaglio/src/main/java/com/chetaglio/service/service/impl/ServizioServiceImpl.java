package com.chetaglio.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chetaglio.model.dao.ServizioDAO;
import com.chetaglio.model.entity.Servizio;
import com.chetaglio.service.service.ServizioService;

public class ServizioServiceImpl implements ServizioService {

	@Autowired
	private ServizioDAO servizioDAO;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void create(Servizio servizio) {
		servizioDAO.create(servizio);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void update(Servizio servizio) {
		servizioDAO.update(servizio);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void delete(Servizio servizio) {
		servizioDAO.delete(servizio);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Servizio findById(Long id) {
		return servizioDAO.findById(id);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Servizio> findAll() {
		return servizioDAO.findAll();
	}

}
