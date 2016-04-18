package com.chetaglio.model.dao;

import java.util.List;

import com.chetaglio.model.dao.utility.Pagination;
import com.chetaglio.model.entity.Negozio;

public interface NegozioDAO {

	public void create(Negozio negozio);

	public void update(Negozio negozio);

	public void delete(Negozio negozio);
	
	public Negozio findById(Long id);
	
	public List<Negozio> findAll();
	
	public List<Negozio> findByCittaCategoriaInsegna(Long idCitta, Long idCategoria, String insegna);

	public List<Negozio> findAll(Pagination pagination);
	
	public List<Negozio> findByCittaCategoriaInsegna(Long idCitta, Long idCategoria, String insegna, Pagination pagination);
	
}
