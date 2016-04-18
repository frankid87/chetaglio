package com.chetaglio.model.dao.impl;

import com.chetaglio.model.dao.ServizioDAO;
import com.chetaglio.model.dao.utility.BaseDAO;
import com.chetaglio.model.entity.Servizio;

public class ServizioDAOImpl extends BaseDAO<Servizio> implements ServizioDAO {

	@Override
	public Class<Servizio> getTargetClass() {
		return Servizio.class;
	}

}