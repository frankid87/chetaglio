package com.chetaglio.service.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.chetaglio.model.dao.CategoriaDAO;
import com.chetaglio.model.entity.Categoria;
import com.chetaglio.service.adapter.CategoriaAdapter;
import com.chetaglio.service.dto.CategoriaDTO;
import com.chetaglio.service.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaDAO categoriaDAO;

	@Autowired
	private CategoriaAdapter categoriaAdapter;

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void create(CategoriaDTO categoria) {
		categoriaDAO.create(categoriaAdapter.fromDtoToEntity(categoria));
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void update(CategoriaDTO categoria) {
		categoriaDAO.update(categoriaAdapter.fromDtoToEntity(categoria));	
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void delete(CategoriaDTO categoria) {
		categoriaDAO.delete(categoriaAdapter.fromDtoToEntity(categoria));		
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public CategoriaDTO findById(Long id) {
		return categoriaAdapter.fromEntityToDto(categoriaDAO.findById(id));
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<CategoriaDTO> findAll() {
		List<Categoria> listCategoria = categoriaDAO.findAll();

		List<CategoriaDTO> listCategoriaDTO = new ArrayList<CategoriaDTO>();
		for(Categoria categoria: listCategoria){
			listCategoriaDTO.add(categoriaAdapter.fromEntityToDto(categoria));
		}
		return listCategoriaDTO;
	}

}