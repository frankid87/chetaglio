package com.chetaglio.service.service;

import java.util.List;

import com.chetaglio.service.dto.CategoriaDTO;

public interface CategoriaService {

	public void create(CategoriaDTO categoria);

	public void update(CategoriaDTO categoria);

	public void delete(CategoriaDTO categoria);

	public CategoriaDTO findById(Long id);

	public List<CategoriaDTO> findAll();

}
