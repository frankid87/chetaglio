package com.chetaglio.model.dao.impl;

import com.chetaglio.model.dao.ImmagineDAO;
import com.chetaglio.model.dao.utility.BaseDAO;
import com.chetaglio.model.entity.Immagine;

public class ImmagineDAOImpl extends BaseDAO<Immagine> implements ImmagineDAO {

	@Override
	public Class<Immagine> getTargetClass() {
		return Immagine.class;
	}

}