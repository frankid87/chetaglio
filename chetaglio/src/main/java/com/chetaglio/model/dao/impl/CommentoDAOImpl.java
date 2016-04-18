package com.chetaglio.model.dao.impl;

import com.chetaglio.model.dao.CommentoDAO;
import com.chetaglio.model.dao.utility.BaseDAO;
import com.chetaglio.model.entity.Commento;

public class CommentoDAOImpl extends BaseDAO<Commento> implements CommentoDAO {

	@Override
	public Class<Commento> getTargetClass() {
		return Commento.class;
	}


}