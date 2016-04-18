package com.chetaglio.model.dao;

import java.util.List;

import com.chetaglio.model.entity.Categoria;

public interface CategoriaDAO {

	public void create(Categoria categoria);

	public void update(Categoria categoria);

	public void delete(Categoria categoria);

	public Categoria findById(Long id);

	public List<Categoria> findAll();

}
