package com.chetaglio.model.dao.impl;

import com.chetaglio.model.dao.CategoriaDAO;
import com.chetaglio.model.dao.utility.BaseDAO;
import com.chetaglio.model.entity.Categoria;

public class CategoriaDAOImpl extends BaseDAO<Categoria> implements CategoriaDAO {

	@Override
	public Class<Categoria> getTargetClass() {
		return Categoria.class;
	}

}