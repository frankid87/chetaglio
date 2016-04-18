package com.chetaglio.service.service;

import java.io.InputStream;
import java.util.List;

import com.chetaglio.service.dto.NegozioDTO;

public interface NegozioService {
	
	public void create(NegozioDTO negozio);
	
	public void update(NegozioDTO negozio);

	public void delete(NegozioDTO negozio);
	
	public NegozioDTO findById(Long id);
	
	public List<NegozioDTO> findAll(int pagina, int numeroRisultatiPagina);
	
	public List<NegozioDTO> findByCittaCategoriaInsegna(Long idCitta, Long idCategoria, String insegna, int pagina, int numeroRisultatiPagina);

	public void saveFromCSV(InputStream stream);
}