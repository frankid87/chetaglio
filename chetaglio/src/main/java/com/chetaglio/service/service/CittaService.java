package com.chetaglio.service.service;

import java.util.List;

import com.chetaglio.service.dto.CittaDTO;

public interface CittaService {

	public void create(CittaDTO citta);

	public void update(CittaDTO citta);

	public void delete(CittaDTO citta);

	public CittaDTO findById(Long id);

	public List<CittaDTO> findAll();

}
