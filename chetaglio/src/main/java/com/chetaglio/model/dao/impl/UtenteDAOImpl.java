package com.chetaglio.model.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;

import com.chetaglio.model.dao.UtenteDAO;
import com.chetaglio.model.dao.utility.BaseDAO;
import com.chetaglio.model.entity.Utente;

public class UtenteDAOImpl extends BaseDAO<Utente> implements UtenteDAO {

	@Override
	public Class<Utente> getTargetClass() {
		return Utente.class;
	}

	public Utente findByUsername(final String username) {
		return getHibernateTemplate().execute(new HibernateCallback<Utente>() {

			public Utente doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(Utente.class);
				criteria.add(Restrictions.eq("username", username));
				return (Utente) criteria.uniqueResult();
			}
		});
	}

}