package com.chetaglio.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chetaglio.model.dao.CommentoDAO;
import com.chetaglio.model.entity.Commento;
import com.chetaglio.service.service.CommentoService;

@Service
public class CommentoServiceImpl implements CommentoService {

	@Autowired
	private CommentoDAO commentoDAO;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void create(Commento commento) {
		commentoDAO.create(commento);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void update(Commento commento) {
		commentoDAO.update(commento);	
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void delete(Commento commento) {
		commentoDAO.delete(commento);		
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Commento findById(Long id) {
		return commentoDAO.findById(id);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Commento> findAll() {
		return commentoDAO.findAll();
	}

}
