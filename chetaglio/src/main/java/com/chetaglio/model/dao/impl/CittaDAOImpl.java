package com.chetaglio.model.dao.impl;

import com.chetaglio.model.dao.CittaDAO;
import com.chetaglio.model.dao.utility.BaseDAO;
import com.chetaglio.model.entity.Citta;

public class CittaDAOImpl extends BaseDAO<Citta> implements CittaDAO {

	@Override
	public Class<Citta> getTargetClass() {
		return Citta.class;
	}
	
}