package com.chetaglio.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;

import com.chetaglio.model.dao.NegozioDAO;
import com.chetaglio.model.dao.utility.BaseDAO;
import com.chetaglio.model.dao.utility.Pagination;
import com.chetaglio.model.entity.Negozio;

public class NegozioDAOImpl extends BaseDAO<Negozio> implements NegozioDAO {

	@Override
	public Class<Negozio> getTargetClass() {
		return Negozio.class;
	}

	public List<Negozio> findByCittaCategoriaInsegna(final Long idCitta, final Long idCategoria, final String insegna){
		return getHibernateTemplate().execute(new HibernateCallback<List<Negozio>>() {

			@SuppressWarnings("unchecked")
			public List<Negozio> doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(Negozio.class, "negozio");
				if(idCategoria != null){
					criteria.createAlias("negozio.servizi", "servizio");
					criteria.add(Restrictions.eq("servizio.categoria.id", idCategoria));
				}
				if(idCitta != null){
					criteria.add(Restrictions.eq("citta.id", idCitta));
				}
				if(insegna != null && !insegna.isEmpty()){
					criteria.add(Restrictions.like("negozio.insegna", insegna, MatchMode.ANYWHERE).ignoreCase());
				}
				return criteria.list();
			}
		});
	}

	public List<Negozio> findByCittaCategoriaInsegna(final Long idCitta, final Long idCategoria, final String insegna, final Pagination pagination){
		return getHibernateTemplate().execute(new HibernateCallback<List<Negozio>>() {

			@SuppressWarnings("unchecked")
			public List<Negozio> doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(Negozio.class, "negozio");
				if(idCategoria != null && idCategoria > 0){
					criteria.createAlias("negozio.servizi", "servizio");
					criteria.add(Restrictions.eq("servizio.categoria.id", idCategoria));
				}
				if(idCitta != null && idCitta > 0){
					criteria.add(Restrictions.eq("citta.id", idCitta));
				}
				if(insegna != null && !insegna.isEmpty()){
					criteria.add(Restrictions.like("negozio.insegna", insegna, MatchMode.ANYWHERE).ignoreCase());
				}
				if(pagination != null){
					criteria.setFirstResult(pagination.getFirstResult());
					criteria.setMaxResults(pagination.getMaxresult());

					for(Order order : pagination.getOrders()){
						criteria.addOrder(order);
					}
				}

				return criteria.list();
			}
		});
	}

	public List<Negozio> findAll(final Pagination pagination){
		return getHibernateTemplate().execute(new HibernateCallback<List<Negozio>>() {

			@SuppressWarnings("unchecked")
			public List<Negozio> doInHibernate(Session session) throws HibernateException {

				Criteria criteria = session.createCriteria(Negozio.class, "negozio");
				
				if(pagination != null){
					criteria.setFirstResult(pagination.getFirstResult());
					criteria.setMaxResults(pagination.getMaxresult());

					for(Order order : pagination.getOrders()){
						criteria.addOrder(order);
					}
				}

				return criteria.list();
			}
		});
	}

}
