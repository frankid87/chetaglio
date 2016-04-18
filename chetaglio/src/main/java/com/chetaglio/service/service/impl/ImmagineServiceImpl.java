package com.chetaglio.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chetaglio.model.dao.ImmagineDAO;
import com.chetaglio.model.entity.Immagine;
import com.chetaglio.service.service.ImmagineService;

@Service
public class ImmagineServiceImpl implements ImmagineService {

	@Autowired
	private ImmagineDAO immagineDAO;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void create(Immagine immagine) {
		immagineDAO.create(immagine);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void update(Immagine immagine) {
		immagineDAO.update(immagine);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void delete(Immagine immagine) {
		immagineDAO.delete(immagine);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public Immagine findById(Long id) {
		return immagineDAO.findById(id);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Immagine> findAll() {
		return immagineDAO.findAll();
	}

}
