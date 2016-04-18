package com.chetaglio.service.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chetaglio.model.dao.CittaDAO;
import com.chetaglio.model.entity.Citta;
import com.chetaglio.service.adapter.CittaAdapter;
import com.chetaglio.service.dto.CittaDTO;
import com.chetaglio.service.service.CittaService;

@Service
public class CittaServiceImpl implements CittaService{

	@Autowired
	private CittaDAO cittaDAO;
	
	@Autowired
	private CittaAdapter cittaAdapter;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void create(CittaDTO citta) {
		cittaDAO.create(cittaAdapter.fromDtoToEntity(citta));
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void update(CittaDTO citta) {
		cittaDAO.update(cittaAdapter.fromDtoToEntity(citta));	
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void delete(CittaDTO citta) {
		cittaDAO.delete(cittaAdapter.fromDtoToEntity(citta));		
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public CittaDTO findById(Long id) {
		return cittaAdapter.fromEntityToDto(cittaDAO.findById(id));
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<CittaDTO> findAll() {
		List<Citta> listCitta = cittaDAO.findAll();
		
		List<CittaDTO> listCittaDTO = new ArrayList<CittaDTO>();
		for(Citta citta: listCitta){
			listCittaDTO.add(cittaAdapter.fromEntityToDto(citta));
		}
		
		return listCittaDTO;
	}

}